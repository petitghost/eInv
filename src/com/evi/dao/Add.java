package com.evi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.evi.model.AddPorder;
import com.evi.model.Cdetail;
import com.evi.model.CsvMain;
import com.evi.model.QRCode;
import com.evi.model.Qdetail;
import com.evi.parser.DateParser;

public class Add {

	public static boolean AddManual(Connection conn, String en,String ed, int si,int uid,int to,String nt) throws SQLException 
	{
		String sql="insert into User_manual(einnumber, eindate, sourceID ,sortID, UID, totalprice, note) "+
				"values(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, en);
			ps.setString(2, ed);
			ps.setInt(3, 0);
			ps.setInt(4, si);
			ps.setInt(5, uid);
			ps.setInt(6, to);
			ps.setString(7, nt);
			
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}

		
	}	
	
	public static boolean isInsertMauSum(Connection conn, String en,String ed,int si,int uid,int to,String nt) throws SQLException 
	{
		
		String sql="insert into Summary_table(einnumber, eindate,sourceID,sortID,UID, totalprice, note)"+" "
				+ "values(?,?,?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, en);
			ps.setString(2, ed);
			ps.setInt(3, 0);
			ps.setInt(4, si);
			ps.setInt(5, uid);
			ps.setInt(6, to);
			ps.setString(7, nt);
			
			ps.executeUpdate();
			
			return true;
					
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	
		
		
	}	
	
	
	public static boolean isInsertSum(Connection con, AddPorder add) throws SQLException {
		
        PreparedStatement insert= null;
       
        String insertStatement =
            "insert into summary_table(einnumber, eindate, sourceID, sortID, UID, totalprice, note)" +
            "values (?, ? ,? ,? , ?, ?, ?)";
        
     
        try {
       
            con.setAutoCommit(false); 
            insert = con.prepareStatement(insertStatement);

           insert.setString(1, add.getEinnumber());
           insert.setString(2, add.getEindate());
           insert.setInt(3, add.getSourceId());
           insert.setInt(4, add.getSortId());
           insert.setInt(5, add.getUID());
           insert.setInt(6, add.getTotalprice());
           insert.setString(7, add.getNote());
           
           int row=insert.executeUpdate(); 
           if(row>0) {
             con.commit(); 
             return true;
           }
           else
               return false;
            
        } catch (Exception e ) { //�s�W���ѷ|�i catch 
            System.out.println(e.getMessage());
            if (con != null) { //�p�G�s�u�٦s�b
                try {
                    System.err.println("Transaction is being rolled back");
                    con.rollback(); //����sql ���O
                } catch(SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } finally {
            if (insert != null) {
                insert.close(); 
            }
            con.setAutoCommit(true); 
        }
        return false;
	}
	
	public static boolean insertCsv(Connection con, CsvMain csvTest) throws SQLException {
		
        PreparedStatement  insert= null;
       
        String insertStatement =
            "insert into upload_main( cardType , cardNo , einnumber , eindate ,sellerID, sellerName, einstatus, totalprice, sourceID, sortID, UID)" +
            "values ( ?, ? ,? ,? , ?, ?, ?, ?, ?, ?, ?)";
        

     
        try {
        
            con.setAutoCommit(false); 
            insert = con.prepareStatement(insertStatement);

           insert.setString(1, csvTest.getCardType());
           insert.setString(2, csvTest.getCardNo());
           insert.setString(3, csvTest.getEinnumber());
           insert.setString(4, csvTest.getEindate());
           insert.setInt(5, csvTest.getSellerID());
           insert.setString(6, csvTest.getSellerName());
           insert.setString(7, csvTest.getEinstatus());
           insert.setInt(8, csvTest.getTotalprice());
           insert.setInt(9, 0);
           insert.setInt(10, 2);
           insert.setInt(11, 11111);
               
           int row=insert.executeUpdate(); //�s�W���\�^��1 �����\�^��0 (���i��>1 �]���@���u�|�s�W�@��)
           if(row>0) {
             con.commit(); 
             return true;
           }
           else
               return false;
            
        } catch (Exception e ) { //�s�W���ѷ|�i catch 
            System.out.println(e.getMessage());
            if (con != null) { //�p�G�s�u�٦s�b
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback(); //����sql ���O
                } catch(SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } finally {
            if (insert != null) {
                insert.close(); 
            }
            con.setAutoCommit(true); 
        }
        return false;
	}
	
	public static boolean insertCsvD(Connection con, Cdetail dtl) throws SQLException {
		
        PreparedStatement  insert= null;
       
        String insertStatement =
            "insert into upload_detail( einnumber , einID , product , price)" +
            "values ( ?, ? ,? ,?)";
     
    
        try {
            
            con.setAutoCommit(false);   
            insert = con.prepareStatement(insertStatement);

           insert.setString(1, dtl.getEinnumber());
           insert.setString(2, dtl.getEinID());
           insert.setString(3, dtl.getProduct());
           insert.setInt(4, dtl.getPrice());
           
      
           int row=insert.executeUpdate(); 
           if(row>0) {
             con.commit();
             return true;
           }
           else
               return false;
            
        } catch (Exception e ) { //�s�W���ѷ|�i catch 
            System.out.println(e.getMessage());
            if (con != null) { //�p�G�s�u�٦s�b
                try {
                    System.out.print("Transaction is being rolled back");
                    con.rollback(); //����sql ���O
                } catch(SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } finally {
            if (insert != null) {
                insert.close(); 
            }
            con.setAutoCommit(true); 
        }
        return false;
	}
	
	
	
	public static boolean isInsertQrcode(Connection con, QRCode qrcode) throws SQLException {
		
        PreparedStatement insert= null;
       
        String insertStatement =
            "insert into QRCode_Main(einnumber, eindate, randomcode, SalesAmount, TotalAmount, sellerID, BIN, sourceID, sortID, UID)" +
            "values (?, ? ,? ,? , ?, ?, ?, ?, ?, ?)";
        
     
        try {
       
            con.setAutoCommit(false); 
            insert = con.prepareStatement(insertStatement);

           insert.setString(1, qrcode.getEinNumber());
           insert.setString(2, DateParser.est2(qrcode.getEinDate()));
           insert.setString(3, qrcode.getRandomCode());
           insert.setString(4, qrcode.getSalesAmount());
           insert.setString(5, qrcode.getTotalAmount());
           insert.setString(6, qrcode.getSellerID());
           insert.setString(7, qrcode.getBin());
           insert.setInt(8, 1);
           insert.setInt(9, 0);
           insert.setInt(10, 11111);
               
          
           int row=insert.executeUpdate(); 
           if(row>0) {
             con.commit(); 
             return true;
           }
           else
               return false;
            
        } catch (Exception e ) { //�s�W���ѷ|�i catch 
            System.out.println(e.getMessage());
            if (con != null) { //�p�G�s�u�٦s�b
                try {
                    System.out.print("Transaction is being rolled back");
                    con.rollback(); //����sql ���O
                } catch(SQLException ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }
            }
        } finally {
            if (insert != null) {
                insert.close(); 
            }
            con.setAutoCommit(true);
        }
        return false;
	}
	
	
	public static boolean isInsertQrcodeD(Connection con, Qdetail qrDetail) throws SQLException {
		
		
        PreparedStatement  insert= null;
       
        String insertStatement =
            "insert into QRCode_Detail( einnumber , einID , product , amount, price, encodingID)" +
            "values ( ?, ? ,? ,?, ?, ?)";
        
    
        try {
           
            con.setAutoCommit(false); 
            insert = con.prepareStatement(insertStatement);

           insert.setString(1, qrDetail.getEinNumber());
           insert.setString(2, qrDetail.getEinID());
           insert.setString(3, qrDetail.getProduct());
           insert.setInt(4, qrDetail.getAmount());
           insert.setInt(5, qrDetail.getSalesAmount());
           insert.setInt(6, qrDetail.getEncodingID());
           
      
           int row=insert.executeUpdate(); 
           if(row>0) {
             con.commit(); 
             return true;
           }
           else
               return false;
            
        } catch (Exception e ) { //�s�W���ѷ|�i catch 
            System.out.println(e.getMessage());
            if (con != null) { //�p�G�s�u�٦s�b
                try {
                    System.out.print("Transaction is being rolled back");
                    con.rollback(); 
                } catch(SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } finally {
            if (insert != null) {
                insert.close(); 
            }
            con.setAutoCommit(true); 
        }
        return false;
	}

}
