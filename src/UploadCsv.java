

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

import dbConn.Conn;
import dbDao.Add;
import model.AddPorder;
import model.Cdetail;
import model.CsvMain;

@MultipartConfig
@WebServlet("/UploadCsv")
public class UploadCsv extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //ï¿½]ï¿½wï¿½sï¿½X 
		response.setCharacterEncoding("UTF-8"); //ï¿½pï¿½Gï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½nï¿½ï¿½ï¿½sï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½sï¿½X
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Part part = request.getPart("file1");
        String filename = getFilename(part);
        
        try {
			String result = writeTo(filename, part);
			//request.setAttribute("result", "1"); 
			response.getWriter().append(result);
			response.getWriter().close();
		} catch (Exception e) {
			//request.setAttribute("result", e.getMessage()); 
			System.out.print(e.getMessage());
			response.getWriter().append("·s¼W¥¢±Ñ");
			response.getWriter().close();
		}
        
        
	}
	
	
	private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        return filename;
    }
	 
    private String writeTo(String filename, Part part) throws IOException,  SQLException {
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
        		//System.out.print(s);
        		String[] details = s.split("\\|"); 
        		CsvMain csvTest=new CsvMain(details);
        		AddPorder sum=new AddPorder(details);
        		iIC=Add.insertCsv(con, csvTest);
        		iIS=Add.isInsertSum(con, sum);
        		
        	}else if(s.startsWith("D")) {
        		count++;
        		//System.out.print(s);
        		Cdetail dtl=new Cdetail(s, count);
        		iICD=Add.insertCsvD(con, dtl);
        		
        	}
        	//System.out.print("\n");
        }
        
        reader.close();
        isr.close();  
        in.close();   
        
        if(iIC && iIS && iICD)
			return "·s¼W¦¨¥\";
		else
			return "·s¼W¥¢±Ñ";

    }


}
