package com.evi.model;

public class Member {

	private int uid;
	private String createDate;
	private String username;
	private String password;
	private String email;
	private int status;
	private String note;
	
	
	
	
	public Member(String createDate, String username, String password, String email, int status) {
	
		setCreateDate(createDate);
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setStatus(status);
	}
	
	
	public int getUid() {
		return uid;
	}
	private void setUid(int uid) {
		this.uid = uid;
	}
	public String getCreateDate() {
		return createDate;
	}
	private void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUsername() {
		return username;
	}
	private void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	private void setStatus(int status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	private void setNote(String note) {
		this.note = note;
	}
	
}
