

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConn.Conn;
import dbDao.Delete;

@WebServlet("/DelEntry")
public class DelEntry extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean b=false;
		
		try {
			Connection con=Conn.con();
			b = Delete.isEinNumberDel(con, "einnumber");
		
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
		}
		
		if(b) {
			response.getWriter().append("Sucessful");
		}else {
			response.getWriter().append("Failed");
		}
		response.getWriter().close();	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
