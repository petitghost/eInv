package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.QRCode;
import model.Qdetail;
import parse.ParseQrCode;

public class parseTest {

	
	@Test
	public void qrCodeParseTestMos() {
		String s ="SW596348991080715352300000296000002b70000000038592428U13bW+9fQFCtsnrGRcRpJw==:**********:3:11:1:新燒肉珍珠堡            0001000052:1:70:a大薯套加$40            0100000218:1:40:玉米濃湯(新)            0400000026:1:40";
		ParseQrCode qrtest= new ParseQrCode(s);
		
		QRCode qr = qrtest.getQr();
		assertEquals("SW59634899",qr.getEinNumber());
		assertEquals("1080715",qr.getEinDate());
		assertEquals("3523",qr.getRandomCode());
		assertEquals("00000296",qr.getSalesAmount());
		assertEquals("000002b7",qr.getTotalAmount());
		assertEquals("00000000",qr.getSellerID());
		assertEquals("38592428",qr.getBin());
		
		ArrayList<Qdetail> qrDetails=qrtest.getQrDetail();
		assertEquals("SW59634899",qrDetails.get(0).getEinNumber());
		assertEquals(1,qrDetails.get(0).getEncodingID());
		assertEquals("新燒肉珍珠堡            0001000052",qrDetails.get(0).getProduct());
		assertEquals(1,qrDetails.get(0).getAmount());
		assertEquals(70,qrDetails.get(0).getSalesAmount());
		
		assertEquals("SW59634899",qrDetails.get(1).getEinNumber());
		assertEquals(1,qrDetails.get(1).getEncodingID());
		assertEquals("a大薯套加$40            0100000218",qrDetails.get(1).getProduct());
		assertEquals(1,qrDetails.get(1).getAmount());
		assertEquals(40,qrDetails.get(1).getSalesAmount());
		
		assertEquals("SW59634899",qrDetails.get(2).getEinNumber());
		assertEquals(1,qrDetails.get(2).getEncodingID());
		assertEquals("玉米濃湯(新)            0400000026",qrDetails.get(2).getProduct());
		assertEquals(1,qrDetails.get(2).getAmount());
		assertEquals(40,qrDetails.get(2).getSalesAmount());
	}
	

	@Test
	public void qrCodeParseTestMac() {
		String s ="UQ4865549810810044400000000320000003200000000843067709/QXXDRKBaf7qwugjrXwXw==:**********:2:3:1:C美式辣雞堡:1:22:C可樂_小:1:28:";
		ParseQrCode qrtest= new ParseQrCode(s);
		
		QRCode qr = qrtest.getQr();
		assertEquals("UQ48655498",qr.getEinNumber());
		assertEquals("1081004",qr.getEinDate());
		assertEquals("4400",qr.getRandomCode());
		assertEquals("00000032",qr.getSalesAmount());
		assertEquals("00000032",qr.getTotalAmount());
		assertEquals("00000000",qr.getSellerID());
		assertEquals("84306770",qr.getBin());
		
		ArrayList<Qdetail> qrDetails=qrtest.getQrDetail();
		assertEquals("UQ48655498",qrDetails.get(0).getEinNumber());
		assertEquals(1,qrDetails.get(0).getEncodingID());
		assertEquals("C美式辣雞堡",qrDetails.get(0).getProduct());
		assertEquals(1,qrDetails.get(0).getAmount());
		assertEquals(22,qrDetails.get(0).getSalesAmount());
		
		assertEquals("UQ48655498",qrDetails.get(1).getEinNumber());
		assertEquals(1,qrDetails.get(1).getEncodingID());
		assertEquals("C可樂_小",qrDetails.get(1).getProduct());
		assertEquals(1,qrDetails.get(1).getAmount());
		assertEquals(28,qrDetails.get(1).getSalesAmount());
	}
	
	
	
}
