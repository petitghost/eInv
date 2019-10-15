package parse;


public class Wes2Chi {
	
	public static String parse(String chiDate){ //1081010
		
		int year = Integer.parseInt(chiDate.substring(0,3)); //108
		int wesYear = 1911 + year;
		String wesDate = wesYear+chiDate.substring(3,7);
		
		
		return wesDate;
	}
}
