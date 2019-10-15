package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import parse.Wes2Chi;

public class wes2chi {

	@Test
	public void qrCodeParseTestMos() {
		String s ="1081010";
		assertEquals("20191010",Wes2Chi.parse(s));
		
	}
	

}
