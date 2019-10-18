package dbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	public static boolean isEinNumberDel(Connection con, String einnumber, String tablename) throws SQLException {
		
        PreparedStatement stmt = null;
        String sql = "delete from " + tablename + " where einnumber=? ";
       
        try {
        		
            stmt = con.prepareStatement(sql);
            stmt.setString(1, einnumber); 
            stmt.executeUpdate();         
            	return true;	
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (stmt != null) {
                stmt.close();    
            }
        }
	}
}
