package result;

import java.sql.Connection;
import java.util.HashMap;

import dbDao.Search;

public class PieChart {

	private int foodCost;
	private int trspCost;
	private int utilCost;
	private int enterCost;
	private int medCost;
	private int otherCost;
	
	public PieChart(Connection conn, String ei1,String ei2, int si, String to) {
		
		HashMap<String, Integer> map = Search.queryChart(conn, ei1, ei2, si, to);
		setFoodCost(map.get("飲食"));
		setTrspCost(map.get("交通"));
		setUtilCost(map.get("日常生活"));
		setEnterCost(map.get("娛樂"));
		setMedCost(map.get("醫療"));
		setOtherCost(map.get("其他"));
		
		
		
		System.out.println("food: " + map.get("飲食"));
		System.out.println("transports: " + map.get("交通"));
		System.out.println("util: " + map.get("日常生活"));
		System.out.println("enter: " + map.get("娛樂"));
		System.out.println("med: " + map.get("醫療"));
		System.out.println("other: " + map.get("其他"));
	}
	
	
	public int getFoodCost() {
		return foodCost;
	}
	private void setFoodCost(int foodCost) {
		this.foodCost = foodCost;
	}
	public int getTrspCost() {
		return trspCost;
	}
	private void setTrspCost(int trspCost) {
		this.trspCost = trspCost;
	}
	public int getUtilCost() {
		return utilCost;
	}
	private void setUtilCost(int utilCost) {
		this.utilCost = utilCost;
	}
	public int getEnterCost() {
		return enterCost;
	}
	private void setEnterCost(int enterCost) {
		this.enterCost = enterCost;
	}
	public int getMedCost() {
		return medCost;
	}
	private void setMedCost(int medCost) {
		this.medCost = medCost;
	}
	public int getOtherCost() {
		return otherCost;
	}
	private void setOtherCost(int otherCost) {
		this.otherCost = otherCost;
	}
	
	
	
	
}
