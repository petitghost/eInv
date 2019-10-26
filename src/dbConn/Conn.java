package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

	public static Connection con()
	{
//		String url="jdbc:mysql://150.117.232.199:33306/money?useSSL=false";
//		String user="admin";
		String url="jdbc:mysql://localhost:3306/evi";
		String user="root";
		String password="1234";
		Connection connDB=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connDB=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connDB;
			
	
	}
}
