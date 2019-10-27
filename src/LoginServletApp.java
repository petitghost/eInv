

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoMember.Search;
import dbConn.Conn;


@WebServlet("/LoginServletApp")
public class LoginServletApp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");  
	    
	    String n=request.getParameter("username");  
	    String p=request.getParameter("password");  
	    
	    Connection conn=Conn.con();
	    
	    int uid=Search.login(conn,n, p);
	          	    
	    if(uid!= -1){
	    	request.setAttribute("userid", uid);
	    	response.getWriter().append("Sucessful");
	         
	    }  
	    else{  
	    	response.getWriter().append("Failed");  
	    }  
	          
	    
	   
	}


}
