package dbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	public static boolean isEinNumberDel(Connection con, String einnumber) throws SQLException {
		
        PreparedStatement stmt = null;
        String sql = "delete from Summary_table where einnumber=? ";
       
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
