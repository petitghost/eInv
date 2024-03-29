package com.evi.ctrl;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evi.conn.Conn;
import com.evi.dao.Update;


@WebServlet("/UpdateEntry")
public class UpdateEntry extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("UTF-8"); 
		
		String einnumber = request.getParameter("einnumber");
		int totalprice = Integer.parseInt(request.getParameter("totalprice"));
		int sortid = Integer.parseInt(request.getParameter("sortID"));
		String note = request.getParameter("note");
		
		boolean b=false;
		
		try {
			Connection con=Conn.con();
			b = Update.isEinNumberUpd(con, einnumber, sortid, totalprice, note);
			
			
		} catch (Exception e) {
			
			System.out.print(e.getMessage());
		}
		
		if(b) {
			response.getWriter().append("修改成功");
		}else {
			response.getWriter().append("修改失敗");
		}
				
		response.getWriter().close();	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
