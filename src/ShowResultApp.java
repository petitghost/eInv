

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConn.Conn;
import dbDao.Search;
import model.AddPorder;

/**
 * Servlet implementation class ShowResultApp
 */
@WebServlet("/ShowResultApp")
public class ShowResultApp extends HttpServlet {
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String ei1=request.getParameter("eindate1");
		String ei2=request.getParameter("eindate2");
		String si=request.getParameter("sortID");
		String to=request.getParameter("totalprice");
		
//		String ei1="2019-10";
//		String ei2="2019-10";
//		String si="-1";
//		String to="-1";
				
		
		
		Connection conn=Conn.con();
		String data=Search.queryResultApp(conn, ei1, ei2, Integer.parseInt(si), to);
		

		response.getWriter().append(data); 
		response.getWriter().close();	
		
		
		
	}

}
