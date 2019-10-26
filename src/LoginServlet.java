

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoMember.Search;
import dbConn.Conn;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    
	          
	    String n=request.getParameter("username");  
	    String p=request.getParameter("password");  
	    
	    Connection conn=Conn.con();
	    
	    int uid=Search.login(conn,n, p);
	          
	    if(uid!= -1){
	        request.setAttribute("userid", uid);
	        request.getRequestDispatcher("dao/add.jsp").forward(request,response);  
	    }  
	    else{  
	        request.getRequestDispatcher("member/login.jsp").include(request,response);  
	    }  
	          
	    
	   
	}


}
