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


@WebServlet("/AddManual")
public class AddManual extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
		Connection con=Conn.con();
		//String en=request.getParameter("einnumber"); //server自行產生發票號碼(pk)
		String ed=request.getParameter("eindate");

		//String uid=request.getParameter("UID");
		String tp=request.getParameter("totalprice");
		String nt=request.getParameter("note");
		
		//int sin=-1;
		String si=request.getParameter("sortID"); //要查詢類別表格
		//System.out.print(si);
		
//		try {
//			sin = Search.categoryName(con, si);
//		} catch (SQLException e1) {
//			
//			e1.getMessage();
//		}
		
		
		
		boolean b=false;
		boolean b1=false;
		
		try {
			b = Add.AddManual(con, "21401015", ed, Integer.parseInt(si),1111, Integer.parseInt(tp), nt);
			b1 = Add.isInsertMauSum(con, "21401015", ed, Integer.parseInt(si), 1111, Integer.parseInt(tp), nt);
			
		
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		if(b && b1) {
			response.getWriter().append("sucessful");
		}else {
			response.getWriter().append("failed");
		}
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
