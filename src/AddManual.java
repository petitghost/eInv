import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConn.Conn;
import dbDao.Add;
import dbDao.Search;


@WebServlet("/AddManual")
public class AddManual extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		
		String ed=request.getParameter("eindate");
		String si=request.getParameter("sortID"); 
		String uid=(String)request.getAttribute("UID");
		String tp=request.getParameter("totalprice");
		String nt=request.getParameter("note");
		
		System.out.print(uid);
		
		boolean b=false;
		boolean b1=false;
		
		try {
			Connection con=Conn.con();
			int count = Search.manualCount(con)+1;
			String en="A"+ count;
			
			if(Search.isEinNumberDup(con, en, "User_manual")) {
				System.out.println("Duplicate entry EinNumber on Manual");
			}else{
				b = Add.AddManual(con, en, ed, Integer.parseInt(si),Integer.parseInt(uid), Integer.parseInt(tp), nt);
			}
			
			if(Search.isEinNumberDup(con, en, "Summary_table")) {
				System.out.println("Duplicate entry EinNumber on summary");
				
			}else{
				b1 = Add.isInsertMauSum(con, en, ed, Integer.parseInt(si), Integer.parseInt(uid), Integer.parseInt(tp), nt);
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
