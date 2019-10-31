package com.evi.ctrl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.evi.conn.Conn;
import com.evi.dao.Add;
import com.evi.dao.Search;


@WebServlet("/AddManual")
public class AddManual extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		HttpSession session = request.getSession(false);
		
		String ed=request.getParameter("eindate");
		String si=request.getParameter("sortID"); 
		
		int uid = 1111;
		//int uid=(int)session.getAttribute("userid");
		
		String tp=request.getParameter("totalprice");
		String nt=request.getParameter("note");
		
		
		
		
		boolean b=false;
		boolean b1=false;
		
		try {
			Connection con=Conn.con();
			int count = Search.manualCount(con)+1;
			String en="A"+ count;
			
			if(Search.isEinNumberDup(con, en, "User_manual")) {
				System.out.println("Duplicate entry EinNumber on Manual");
			}else{
				b = Add.AddManual(con, en, ed, Integer.parseInt(si), uid, Integer.parseInt(tp), nt);
			}
			
			if(Search.isEinNumberDup(con, en, "Summary_table")) {
				System.out.println("Duplicate entry EinNumber on summary");
				
			}else{
				b1 = Add.isInsertMauSum(con, en, ed, Integer.parseInt(si), uid, Integer.parseInt(tp), nt);
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
