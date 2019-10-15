package model;

public class Cdetail {

	private String einnumber;
	private String einID;
	private String product;
	private int price;
	
	
	public Cdetail(String s, int count) {
		parse(s, count);
		
	}
	
	private void parse(String s, int count) {
		String[] details = s.split("\\|");
		setEinnumber(details[1]);
		setEinID(details[1]+count);
		setProduct(details[3]);
		setPrice(Integer.parseInt(details[2]));
		
	}
	

	public String getEinnumber() {
		return einnumber;
	}

	private void setEinnumber(String einnumber) {
		this.einnumber = einnumber;
	}

	public String getProduct() {
		return product;
	}

	private void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	private void setPrice(int price) {
		this.price = price;
	}

	public String getEinID() {
		return einID;
	}

	private void setEinID(String einID) {
		this.einID = einID;
	}

}
