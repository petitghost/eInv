

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
		boolean b1=false;
		
		String id=request.getParameter("einnumber");
		String sourceid=request.getParameter("sourceId");
		char c = sourceid.charAt(0);
		
		
		try {
			Connection con=Conn.con();
			b = Delete.isEinNumberDel(con, id, "summary_table");
			//b = Delete.isEinNumberDel(con, "VA06298492");
			switch(c) {
				case '0': //manual
					b1 = Delete.isEinNumberDel(con, id, "user_manual");
					break; 
					
				case '1'://qr
					if(Delete.isEinNumberDel(con, id, "qrcode_detail") 
							&& Delete.isEinNumberDel(con, id, "qrcode_main"))
						b1=true;
					break;
					
					
				case '2'://csv
					if(Delete.isEinNumberDel(con, id, "upload_detail") 
							&& Delete.isEinNumberDel(con, id, "upload_main"))
						b1=true;
					break;
					
					
				default:
					b1=false;
					
			}
		
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
		}
		
		if(b && b1) {
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
