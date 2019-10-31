package com.evi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	
	public static boolean isEinNumberUpd(Connection con, String einnumber, int sortID, int totalprice, String note) throws SQLException {
		
        
        String sql = "update Summary_table set einnumber=einnumber";
        
        if(sortID!=-1)
        		sql += " ,sortID="+sortID;
        if(totalprice!=-1)
            sql += " ,totalprice="+totalprice;	
        if(note!="")
            sql += " ,note='"+note+"'";	
        
        sql += "where einnumber='"+einnumber+"'";
       
        PreparedStatement stmt = null;
        try {
        		
            stmt = con.prepareStatement(sql);            
            stmt.executeUpdate();         
            	return true;	
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (stmt != null) {
                stmt.close();    
            }
        }
	}
}
