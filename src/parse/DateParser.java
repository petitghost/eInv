package parse;


public class DateParser {
	
	public static String est2(String chiDate){ //1081010
		
		int year = Integer.parseInt(chiDate.substring(0,3)); //108
		int wesYear = 1911 + year;
		String wesDate = wesYear+chiDate.substring(3,7);
		
		
		return wesDate;
	}
	
	
}
