package daoMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
	
	public static int login(Connection con,String username,String password){  
		 
		int uid=-1;
		
		try{  
			
			String sql="select UID from account where username=? and password=?";
				
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setString(1,username);  
			ps.setString(2,password);  
			    
			
			ResultSet rs=ps.executeQuery(); 
			while(rs.next()) {
				uid=rs.getInt("UID");
				
			}
			return uid;
		
		
		}		
		catch(Exception e)
		{
			System.out.println(e);
		} 
		
		return uid;  
	}  


	
	public static boolean isMemberDup(Connection con, String name) throws SQLException {
		int count=0;
		
        PreparedStatement stmt = null;
        String query = "select * from account where username=? ";
        try {
        		
            stmt = con.prepareStatement(query);
            stmt.setString(1, name); 
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
