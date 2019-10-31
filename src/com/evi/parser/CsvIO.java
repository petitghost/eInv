package com.evi.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.evi.conn.Conn;
import com.evi.dao.Add;
import com.evi.model.AddPorder;
import com.evi.model.Cdetail;
import com.evi.model.CsvMain;

public class CsvIO {

	public static void csvRead(String filePath) {
		Connection con=Conn.con();
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
        
		    reader = new BufferedReader(new FileReader(file));
		    String s = null;
		    int count=0;
        
	        while ((s = reader.readLine()) != null){
	        	if(s.startsWith("M")) {
	        		count=0;
	        		String[] details = s.split("\\|"); 
	        		CsvMain csvTest=new CsvMain(details);
	        		AddPorder sum=new AddPorder(details);
	        		Add.insertCsv(con, csvTest);
	        		Add.isInsertSum(con , sum);
	        		
	        	}else if(s.startsWith("D")) {
	        		count++;
	        		
	        		Cdetail dtl=new Cdetail(s, count);
	        		Add.insertCsvD(con, dtl);
	        		
	        	}
	        	System.out.print("\n");
	        }
	        reader.close();
        } catch (Exception e) {
        	System.out.print(e.getMessage());
        } finally {
	        if (reader != null){
		        try {
		        	reader.close();
		        } catch (IOException e1) {
		        }
	        }
        }
	
	}
	
	public static void main(String[] args) throws IOException, SQLException {
		//csvRead("C:\\Users\\Administrator\\Desktop\\doc\\1-2.csv");
		csvRead("/Users/petitghost/Desktop/098832070001.csv");
		
	}

}
