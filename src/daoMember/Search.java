package daoMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
	
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
