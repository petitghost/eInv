package com.evi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.evi.model.AddPorder;
import com.evi.parser.DateParser;
import com.google.gson.Gson;

public class Search {
	
	public static int manualCount(Connection conn) {
		int count =0;
		String sql = "select * from user_manual";
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.last())
				count = rs.getRow();
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		
		return count;
	}
	
	
	public static String queryResultApp(Connection conn, String ei1,String ei2, int si, String to) 
	{
		
		List<AddPorder> data=Search.queryResultWeb(conn, ei1, ei2, si, to);
		Gson gs=new Gson();
		String str=gs.toJson(data);
    
		return str;
	
	}	
	
	
	public static HashMap<String, Integer> queryChart(Connection conn, String ei1,String ei2, int si, String to){
		int foodCost=0, transCost=0, untilCost=0, enterCost=0, medCost=0, otherCost=0;
		
		List<AddPorder> data=Search.queryResultWeb(conn, ei1, ei2, si, to);
		
		for(int i=0;i<data.size();i++){
			
			switch(data.get(i).getSortId()){
			
				case (1):
					foodCost+=data.get(i).getTotalprice();
					break;
				case (2):
					transCost+=data.get(i).getTotalprice();
					break;
				case (3):
					untilCost+=data.get(i).getTotalprice();
					break;
				case (4):
					enterCost+=data.get(i).getTotalprice();
					break;
				case (5):
					medCost+=data.get(i).getTotalprice();
					break;
				case (6):
					otherCost+=data.get(i).getTotalprice();
					break;
			}
		}
		
		
		HashMap<String, Integer> map = new HashMap<>();
        map.put("飲食", foodCost); 
        map.put("交通", transCost);
        map.put("日常生活", untilCost);
        map.put("娛樂", enterCost);
        map.put("醫療", medCost);
        map.put("其他", otherCost);
        
        return map;
	}
	
	
	public static List<AddPorder> queryResultWeb(Connection conn, String ei1,String ei2, int si, String to) 
	{
		List<AddPorder> data=new ArrayList<>();
		
		try {
			
			String sql = "SELECT definition_sort.sortID ,sortName ,summary_table.eindate, einnumber, UID, totalprice, note, sourceID\n" + 
					"FROM definition_sort  INNER JOIN summary_table  ON definition_sort.sortID = summary_table.sortID\n" + 
					"where 1=1";
			
			if(ei1!="" && ei2!="") {
				String[] start = ei1.split("-");
				String[] end = ei2.split("-");
				int first=DateParser.firstDay(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
				int last=DateParser.lastDay(Integer.parseInt(end[0]), Integer.parseInt(end[1])); 
				
				//System.out.println("first: "+first);
				//System.out.println("end: "+last);
				
				sql+=" AND eindate >='" + start[0] + "-" +start[1] + "-" + first + 
						"' AND eindate<=LAST_DAY('" + end[0] + "-" +end[1] + "-" + last +
						"')"; 
				//and eindate >='2019-08-01' AND eindate<=LAST_DAY('2019-10-02')
				
			}if(si!=-1) {
				sql += " AND summary_table.sortID=" + si;  //sortID=1
				
			}
			
			if(!to.equals("-1")) {
				
				if(to.contains("以上")) {
					sql += " AND totalprice BETWEEN 10000 AND 1000000000"; // totalprice BETWEEN 10000 AND 1000000000
				}
				else {
					String[] tokens = to.split("~");
					sql += " AND totalprice BETWEEN " + tokens[0]+ " AND " + tokens[1]; // totalprice BETWEEN 200 AND 5000
				}
			}
			
			sql += " order by eindate desc";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			
			 while(rs.next()) {
	                AddPorder ex=new AddPorder(rs.getString("sortName"),
	                		rs.getInt("sortID"),
	                		rs.getInt("UID"),
	                		rs.getInt("totalprice"),
	                		rs.getString("einnumber"),
	                		rs.getString("eindate"),
	                		rs.getString("note"));
	                
	                data.add(ex);
	         }
			 
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return data;		
		
	}	

	
	public static boolean isEinNumberDup(Connection con, String einnumber, String tableName) throws SQLException {
		int count=0;
		
        PreparedStatement stmt = null;
        String query = "select * from "+ tableName +" where einnumber=? ";
        
        try {
        		
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
		
        PreparedStatement stmt = null;
        String query = "select * from "+ tableName +" where einID=? ";
        try {
        		
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
