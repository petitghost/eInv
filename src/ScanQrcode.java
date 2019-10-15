

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConn.Conn;
import dbDao.Add;
import model.AddPorder;
import model.QRCode;
import model.Qdetail;


@WebServlet("/ScanQrcode")
public class ScanQrcode extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		boolean iIQ=false;
		boolean iIS=false;
		boolean iIQD=false;
		//String s ="U14865549810810044400000000320000003200000032843067709/QXXDRKBaf7qwugjrXwXw==:**********:2:3:1:C����������:1:22:C�i��_�p:1:28:";
		String s = request.getParameter("str");
		System.out.println("QRcode"+s);
		QRCode qr = new QRCode(s);
		AddPorder sum=new AddPorder(s);
		Connection con=Conn.con();
	
		
		try {
			iIQ=Add.isInsertQrcode(con, qr);
			iIS=Add.isInsertSum(con, sum);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return;
		}
		
		String[] details = s.split(":");
		int count= (details.length-5)/3;
		try {
			for(int i=0;i<count;i++) {
			
				Qdetail qdetail= new Qdetail(details[0].substring(0,10),
						i+1+"",
						Integer.parseInt(details[4]), 
						details[5+(i*3)], 
						Integer.parseInt(details[6+(i*3)]), 
						Integer.parseInt(details[7+(i*3)]));
			
			
				iIQD=Add.isInsertQrcodeD(con, qdetail);
			}
			
			if(iIQ && iIS && iIQD)
				response.getWriter().append("sucessful");
			else
				response.getWriter().append("failed");
			
			response.getWriter().close();	
		
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
