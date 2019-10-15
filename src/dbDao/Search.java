package dbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.AddPorder;

public class Search {
	
	
	public static int categoryName(Connection con, String sortID) throws SQLException {
		int i=-1;
		PreparedStatement stmt = null;
		String query = "select sortID from Definition_Sort where sortName=? ";
		
		stmt = con.prepareStatement(query);
        stmt.setString(1, sortID); 
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {                       
            i = rs.getInt("sortID");
         
        }
		
		return i;
	}
	
	public static String JudgeAuditQuery(Connection conn, String ei1,String ei2, int si, String to) 
	{
		String aud="0";
		//Connection conn=Conn.con();
		//String sql="insert into banana.account(uid,username,password,email) values(?,?,?,?)";
		String sql="SELECT * FROM peer.Summary_table WHERE 1=1";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			
			if(ei1!="" && ei2!="") {
				sql+=" AND eindate BETWEEN '" + ei1 + "' AND LAST_DAY('" + ei2 + "')"; //eindate BETWEEN '2019-08' AND LAST_DAY('2019-10-02')
	
			}
			if(si!=-1) {
				sql += " AND sortID=" + si;  //sortID=1
			}
			if(to!="-1") {
				if(to.contains("¥H¤W")) {
					sql += " AND totalprice BETWEEN 10000 AND 1000000000"; // totalprice BETWEEN 10000 AND 1000000000
				}
				else {
					String[] tokens = to.split("~");
					sql += " AND totalprice BETWEEN " + tokens[0]+ " AND " + tokens[1]; // totalprice BETWEEN 200 AND 5000
				}
			}
			
			
			
			ResultSet rs=ps.executeQuery();
			List<AddPorder> data=new ArrayList<>();
			 while(rs.next()) {
	                AddPorder ex=new AddPorder(rs.getInt("sourceID"),
	                		rs.getInt("sortID"),
	                		rs.getInt("UID"),
	                		rs.getInt("totalprice"),
	                		rs.getString("einnumber"),
	                		rs.getString("eindate"),
	                		rs.getString("note"));
	                
	                data.add(ex);
	         }
			 
			 Gson gs=new Gson();
	         String str=gs.toJson(data);
	        
	        return str;
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return aud;		
		
	}	
	
	public static boolean isEinNumberDup(Connection con, String einnumber, String tableName) throws SQLException {
		int count=0;
		//Connection con=null;
        PreparedStatement stmt = null;
        String query = "select * from "+ tableName +" where einnumber=? ";
        try {
        		//con=Conn.con();
            stmt = con.prepareStatement(query);
            stmt.setString(1, einnumber); 
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {             
				++count;
            }
            if(count!=0)
            		return true;	
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (stmt != null) {
                stmt.close();    
            }
        }
		return false;
	}

	public static boolean isEinIdDup(Connection con, String einID, String tableName) throws SQLException {

		int count=0;
		//Connection con=null;
        PreparedStatement stmt = null;
        String query = "select * from "+ tableName +" where einID=? ";
        try {
        		//con=Conn.con();
            stmt = con.prepareStatement(query);
            stmt.setString(1, einID); 
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {             
				++count;
            }
            if(count!=0)
            		return true;	
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (stmt != null) {
                stmt.close();    
            }
        }
		return false;
	}
}
