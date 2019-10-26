package daoMember;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Member;

public class Add {

	public static boolean isAdd(Connection con, Member m) 
	{
		
		String sql="insert into account(CreatDate,username,password,email,status) values(?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getCreateDate());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getEmail());
			ps.setInt(5, m.getStatus());
			
			ps.executeUpdate();
			
			
			return true;
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		return false;
		
		
	}

	public static void main(String[] args) {
//		porder p=new porder(2,"a","a","a");
//		
//		String us="peter";
//		String pw="1111";
//		String em="peter@yahoo.com.tw";
//		Add.add(us,pw,em);

	}



}
