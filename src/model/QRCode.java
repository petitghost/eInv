package model;

public class QRCode {
	private String einNumber;
	private String einDate;
	private String randomCode;
	private String salesAmount;
	private String totalAmount;
	private String sellerID;
	private String bin;
	
	public QRCode(String s){
		setEinNumber(s.substring(0,10));
		setEinDate(s.substring(10,17));
		setRandomCode(s.substring(17,21));
		setSalesAmount(s.substring(21,29));
		setTotalAmount(s.substring(29,37));
		setSellerID((s.substring(37,45)));
		setBin(s.substring(45,53));
	}

	public String getEinNumber() {
		return einNumber;
	}

	private void setEinNumber(String einNumber) {
		this.einNumber = einNumber;
	}

	public String getEinDate() {
		return einDate;
	}

	private void setEinDate(String einDate) {
		this.einDate = einDate;
	}

	public String getRandomCode() {
		return randomCode;
	}

	private void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	public String getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(String salesAmount) {
		this.salesAmount = salesAmount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	private void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSellerID() {
		return sellerID;
	}

	private void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public String getBin() {
		return bin;
	}

	private void setBin(String bin) {
		this.bin = bin;
	}

	
}
