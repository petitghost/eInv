package com.evi.model;

public class CsvMain {

	private String CardType;
	private String getCardNo;
	private String eindate;
	private int sellerID;
	private String sellerName;
	private String einnumber;
	private int totalprice;
	private String einstatus;
	
	public CsvMain(String[] details) {
		setCardType(details[1]);
		setCardNo(details[2]);
		setEindate(details[3]);
		setSellerID(Integer.parseInt(details[4]));
		setSellerName(details[5]);
		setEinnumber(details[6]);
		setTotalprice(Integer.parseInt(details[7]));
		setEinstatus(details[8]);
	}
	

	public String getCardType() {
		return CardType;
	}
	
	private void setCardType(String cardType) {
		CardType = cardType;
	}

	public String getCardNo() {
		return getCardNo;
	}

	private void setCardNo(String getCardNo) {
		this.getCardNo = getCardNo;
	}

	public String getEindate() {
		return eindate;
	}

	private void setEindate(String eindate) {
		this.eindate = eindate;
	}

	public int getSellerID() {
		return sellerID;
	}

	private void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public String getSellerName() {
		return sellerName;
	}

	private void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getEinnumber() {
		return einnumber;
	}

	private void setEinnumber(String einnumber) {
		this.einnumber = einnumber;
	}

	public int getTotalprice() {
		return totalprice;
	}

	private void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getEinstatus() {
		return einstatus;
	}

	private void setEinstatus(String einstatus) {
		this.einstatus = einstatus;
	}
}
