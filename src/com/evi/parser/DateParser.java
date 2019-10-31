package com.evi.parser;

import java.util.Calendar;

public class DateParser {
	
	public static String est2(String chiDate){ //1081010
		
		int year = Integer.parseInt(chiDate.substring(0,3)); //108
		int wesYear = 1911 + year;
		String wesDate = wesYear+chiDate.substring(3,7);
		
		
		return wesDate;
	}
	
	public static int lastDay(int year, int month) {
		
		Calendar c = Calendar.getInstance();
		
	    c.set(Calendar.YEAR, year);
	    c.set(Calendar.MONTH, month-1); //index from 0
	    
	    return c.getActualMaximum(Calendar.DATE);
	    
	}
	
	public static int firstDay(int year, int month) {
		
		Calendar c = Calendar.getInstance();
		
	    c.set(Calendar.YEAR, year);
	    c.set(Calendar.MONTH, month-1); // index from 0
	    
	    return c.getActualMinimum(Calendar.DATE);
	      
	    
	    
	    
	}
	
	
}
