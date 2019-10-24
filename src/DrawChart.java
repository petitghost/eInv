

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConn.Conn;
import dbDao.Search;
import model.AddPorder;
import result.PieChart;

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
		PieChart pie = new PieChart(conn, ei1, ei2, Integer.parseInt(si), to);

		List<PieChart> data =new ArrayList<>();
		data.add(pie);
		
//		request.setAttribute("food", map.get("飲食"));
//		request.setAttribute("transports", map.get("交通"));
//		request.setAttribute("util", map.get("日常生活"));
//		request.setAttribute("enter", map.get("娛樂"));
//		request.setAttribute("med", map.get("醫療"));
//		request.setAttribute("other", map.get("其他"));
		
		
		request.setAttribute("data", data);
		request.getRequestDispatcher("./dao/chart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
