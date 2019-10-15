

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConn.Conn;
import dbDao.Add;
import dbDao.Search;
import model.AddPorder;
import model.QRCode;
import model.Qdetail;


@WebServlet("/ScanQrcode")
public class ScanQrcode extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String s ="U18655498110810044400000000320000003200000032843067709/QXXDRKBaf7qwugjrXwXw==:**********:2:3:1:C����������:1:22:C�i��_�p:1:28:";
		//String s = request.getParameter("str");
		System.out.println("QRcode"+s);
	
		boolean b = write2Qr(s);
		
		
		if(b)
			response.getWriter().append("sucessful");
		else
			response.getWriter().append("failed");
		
		response.getWriter().close();	
	}


	private boolean write2Qr(String s) {
		boolean iIQ=false;
		boolean iIS=false;
		boolean iIQD=false;
		
		QRCode qr = new QRCode(s);
		AddPorder sum=new AddPorder(s);
		
		
		try {
			Connection con=Conn.con();
			
			if(Search.isEinNumberDup(con, qr.getEinNumber(), "QRCode_Main")){
				System.out.println("Duplicate entry EinNumber");
				
			}else{
				iIQ=Add.isInsertQrcode(con, qr);
			}
			
			
			if(Search.isEinNumberDup(con, sum.getEinnumber(), "summary_table")){
				System.out.println("Duplicate entry EinNumber on summary");
				
			}else{
				iIS=Add.isInsertSum(con, sum);
			}
		
			
			String[] details = s.split(":");
			int count= (details.length-5)/3;
		
			
			for(int i=0;i<count;i++) {
			
				Qdetail qdetail= new Qdetail(details[0].substring(0,10),
						i+1+"",
						Integer.parseInt(details[4]), 
						details[5+(i*3)], 
						Integer.parseInt(details[6+(i*3)]), 
						Integer.parseInt(details[7+(i*3)]));
			
				if(Search.isEinIdDup(con, qdetail.getEinID(), "QRCode_Detail")){
					System.out.println("Duplicate entry EinId");
					
				}else{
					iIQD=Add.isInsertQrcodeD(con, qdetail);
				}
			}
			
			if(iIQ && iIS && iIQD){
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return false;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
