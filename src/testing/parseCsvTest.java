package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Cdetail;
import model.CsvMain;

public class parseCsvTest {

	@Test
	public void csvTest() {
		String s="M|�����d|20160613135829200.00 |20190728|53333891|�w�߭��~�A�Ȫѥ��������q�d��������q|SW58656186|205|�}��|";
		String[] details = s.split("\\|"); 
		CsvMain csvTest=new CsvMain(details);
		assertEquals("�����d",csvTest.getCardType());
		assertEquals("20160613135829200.00 ",csvTest.getCardNo());
		assertEquals("20190728",csvTest.getEindate());
		assertEquals(53333891,csvTest.getSellerID());
		assertEquals("�w�߭��~�A�Ȫѥ��������q�d��������q",csvTest.getSellerName());
		assertEquals("SW58656186",csvTest.getEinnumber());
		assertEquals(205,csvTest.getTotalprice());
		assertEquals("�}��",csvTest.getEinstatus());
		
	}
	
	@Test
	public void csvDetailTest() {
		String s="D|UX76128391|50|�q�����J�O(M)|";
		int count=1;
		Cdetail dtl=new Cdetail(s, count);
		assertEquals("UX76128391",dtl.getEinnumber());
		assertEquals("UX761283911",dtl.getEinID());
		assertEquals("�q�����J�O(M)",dtl.getProduct());
		assertEquals(50,dtl.getPrice());
	}
	
	@Test
	public void csvDetailTest1() {
		String s="D|SW58656186|50|D���������M�[$50|";
		int count=1;
		Cdetail dtl=new Cdetail(s, count);
		assertEquals("SW58656186",dtl.getEinnumber());
		assertEquals("SW586561861",dtl.getEinID());
		assertEquals("D���������M�[$50",dtl.getProduct());
		assertEquals(50,dtl.getPrice());
	}

}
