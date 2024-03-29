package com.evi.ctrl;


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

import com.evi.chart.PieChart;
import com.evi.conn.Conn;
import com.evi.dao.Search;
import com.evi.model.AddPorder;

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
		
		
		request.setAttribute("pt", pie);
		request.getRequestDispatcher("./dao/chart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
