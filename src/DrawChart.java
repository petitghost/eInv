

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConn.Conn;
import dbDao.Search;

@WebServlet("/DrawChart")
public class DrawChart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String ei1=request.getParameter("eindate1");
		String ei2=request.getParameter("eindate2");
		String si=request.getParameter("sortID");
		String to=request.getParameter("totalprice");
		
		
		Connection conn=Conn.con();
		HashMap<String, Integer> map = Search.queryChart(conn, ei1, ei2, Integer.parseInt(si), to);

		System.out.println("food: " + map.get("飲食"));
		System.out.println("transports: " + map.get("交通"));
		System.out.println("util: " + map.get("日常生活"));
		System.out.println("enter: " + map.get("娛樂"));
		System.out.println("med: " + map.get("醫療"));
		System.out.println("other: " + map.get("其他"));
		
		
		//request.setAttribute("map", map);
		request.setAttribute("food", map.get("飲食"));
		request.setAttribute("transports", map.get("交通"));
		request.setAttribute("util", map.get("日常生活"));
		request.setAttribute("enter", map.get("娛樂"));
		request.setAttribute("med", map.get("醫療"));
		request.setAttribute("other", map.get("其他"));
		request.getRequestDispatcher("./dao/chart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
