package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import parse.DateParser;

public class wes2chi {

	@Test
	public void qrCodeParseTestMos() {
		String s ="1081010";
		assertEquals("20191010",DateParser.est2(s));
		
	}
	

}
