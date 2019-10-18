import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConn.Conn;
import dbDao.Search;
import model.AddPorder;


@WebServlet("/RegistRecep")
public class RegistRecep extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String ei1=request.getParameter("eindate1");
		String ei2=request.getParameter("eindate2");
		String si=request.getParameter("sortID");
		String to=request.getParameter("totalprice");
		
//		String ei1="2019-10";
//		String ei2="2019-10";
//		String si="-1";
//		String to="-1";
				
		
		Connection conn=Conn.con();
		List<AddPorder> data=Search.queryResultWeb(conn, ei1, ei2, Integer.parseInt(si), to);
		
		
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet  SelectSupplier</title>");
//        out.println("</head>");
//        out.println("<body>");
//
//        print(out , data);
//
//        out.println("</body>");
//        out.println("</html>");   
//        out.close();
		
		
		
		
//		response.getWriter().append(aud); //會跟跳轉頁面衝突
//		response.getWriter().close();	
		//System.out.println(data.get(0).getTotalprice());
		request.setAttribute("data", data);
		request.getRequestDispatcher("./dao/showResult.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
//	public void print(PrintWriter out ,List<AddPorder> data)
//    {    
//		out.println("<table border='1'>");
//		out.println("<tr>");
//		out.println("<td>日期</td><td>金額</td><td>種類</td><td>備註</td><td>操作</td>");
//		
//        for(int i=0; i<data.size();i++) {
//        	AddPorder tmp = data.get(i);
//        	
//        	out.println("<tr><td>");
//        	String eindate = tmp.getEindate();
//        	out.println(""+eindate);
//            out.println("</td><td>");
//            
//            
//        	int sortID = tmp.getSortID();
//        	out.println(""+sortID);
//            out.println("</td><td>");
//            
//            
//        	int totalprice = tmp.getTotalprice();
//        	out.println(""+totalprice);
//            out.println("</td><td>");
//            
//            
//        	String note = tmp.getNote();
////        	if(note.equals("null"))
////        		out.println("");
////        	else
//        	out.println(""+note);
//        	out.println("</td><td>");
//            
//        	
//        	out.println("<button onclick=\"myupdate('${pt.studentID}')\">修改</button>");
//        	out.println("</td><td>");
//        	
//        	
//        	out.println("<button onclick=\"mydelete('${pt.studentID}')\">刪除</button>");
//            out.println("</td></tr>");
//        }
//        
//        out.println("</table>");
//        
//        
//       
//    }

}
