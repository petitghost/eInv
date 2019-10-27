

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoMember.Search;
import dbConn.Conn;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");  
		
	          
	    String n=request.getParameter("username");  
	    String p=request.getParameter("password");  
	    
	    Connection conn=Conn.con();
	    
	    int uid=Search.login(conn,n, p);
	          	    	
	    if(uid!= -1){
	    	HttpSession hs=request.getSession(); 
	    	hs.setAttribute("userid", uid);

	    	//session.setAttribute("userid", uid);
	        request.getRequestDispatcher("dao/add.jsp").forward(request,response);  
	    }  
	    else{  
	        request.getRequestDispatcher("member/login.jsp").include(request,response);  
	    }  
	          
	    
	   
	}


}
