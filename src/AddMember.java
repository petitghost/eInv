

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoMember.Add;
import daoMember.Search;
import dbConn.Conn;
import model.Member;


@WebServlet("/AddMember")
public class AddMember extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		String em=request.getParameter("email");
	
		LocalDate now = LocalDate.now();
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String date = now.format(dFormat);
	    
	    boolean b=false;
	    
	    Connection conn=Conn.con();
	    try {
			if(Search.isMemberDup(conn, un))
				System.out.println("Duplicate member");
				else{
					Member m=new Member(date, un, pw, em, 0);
				    b = Add.isAdd(conn, m);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	
	    
		
	    if(b) {
			response.getWriter().append("Sucessful");
		}else {
			response.getWriter().append("Failed");
		}
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
