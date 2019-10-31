package com.evi.ctrl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.evi.conn.Conn;
import com.evi.dao.Add;
import com.evi.dao.Search;
import com.evi.model.AddPorder;
import com.evi.model.Cdetail;
import com.evi.model.CsvMain;

@MultipartConfig
@WebServlet("/UploadCsv")
public class UploadCsv extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		boolean b=false;
		Part part = request.getPart("file1");
        String filename = getFilename(part);
        
        try {
			b = writeTo(filename, part);
		
		} catch (Exception e) {
			System.out.print(e.getMessage());
			
		}
        
        if(b) {
			response.getWriter().append("sucessful");
		}else {
			response.getWriter().append("failed");
		}
				
		response.getWriter().close();	
        
        
	}
	
	
	private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        return filename;
    }
	 
    private boolean writeTo(String filename, Part part) throws IOException,  SQLException {
        InputStream in = part.getInputStream();
        InputStreamReader isr=new InputStreamReader(in);
        BufferedReader reader=new BufferedReader(isr);
        Connection con=Conn.con(); 
        
        boolean iIC=false;
		boolean iIS=false;
		boolean iICD=false;
        String s = null;
	    int count=0;
    
        while ((s = reader.readLine()) != null){
	        	if(s.startsWith("M")) {
	        		count=0;
	        		String[] details = s.split("\\|"); 
	        		
	        		CsvMain csvTest=new CsvMain(details);
	        		AddPorder sum=new AddPorder(details);
	        		
	        		if(Search.isEinNumberDup(con, csvTest.getEinnumber(), "upload_main")){
	        			System.out.println("Duplicate entry EinNumber");
	        			
	        		}else{
	        			iIC=Add.insertCsv(con, csvTest);
	        		}
	        		
	        		if(Search.isEinNumberDup(con, sum.getEinnumber(), "summary_table")){
	    				System.out.println("Duplicate entry EinNumber on summary");
	    				
	    			}else{
	    				iIS=Add.isInsertSum(con, sum);
	    			}
	        		
	        	}else if(s.startsWith("D")) {
	        		count++;
	        	
	        		Cdetail dtl=new Cdetail(s, count);
	        		
	        		if(Search.isEinIdDup(con, dtl.getEinID(), "upload_detail")){
	        			System.out.println("Duplicate entry EinId");
	        			
	        		}else{
	        			iICD=Add.insertCsvD(con, dtl);
	        		}
	        		
	        	}
       
        }
        
        reader.close();
        isr.close();  
        in.close();   
        
        if(iIC && iIS && iICD)
			return true;
		
        return false;

    }


}
