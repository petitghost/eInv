package com.evi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.evi.model.QRCode;
import com.evi.model.Qdetail;
import com.evi.parser.ParseQrCode;

public class parseTest {

	
	@Test
	public void qrCodeParseTestMos() {
		String s ="SW596348991080715352300000296000002b70000000038592428U13bW+9fQFCtsnrGRcRpJw==:**********:3:11:1:�s�N�׬ï]��            0001000052:1:70:a�j���M�[$40            0100000218:1:40:�ɦ̿@��(�s)            0400000026:1:40";
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
		assertEquals("�s�N�׬ï]��            0001000052",qrDetails.get(0).getProduct());
		assertEquals(1,qrDetails.get(0).getAmount());
		assertEquals(70,qrDetails.get(0).getSalesAmount());
		
		assertEquals("SW59634899",qrDetails.get(1).getEinNumber());
		assertEquals(1,qrDetails.get(1).getEncodingID());
		assertEquals("a�j���M�[$40            0100000218",qrDetails.get(1).getProduct());
		assertEquals(1,qrDetails.get(1).getAmount());
		assertEquals(40,qrDetails.get(1).getSalesAmount());
		
		assertEquals("SW59634899",qrDetails.get(2).getEinNumber());
		assertEquals(1,qrDetails.get(2).getEncodingID());
		assertEquals("�ɦ̿@��(�s)            0400000026",qrDetails.get(2).getProduct());
		assertEquals(1,qrDetails.get(2).getAmount());
		assertEquals(40,qrDetails.get(2).getSalesAmount());
	}
	

	@Test
	public void qrCodeParseTestMac() {
		String s ="UQ4865549810810044400000000320000003200000000843067709/QXXDRKBaf7qwugjrXwXw==:**********:2:3:1:C����������:1:22:C�i��_�p:1:28:";
		ParseQrCode qrtest= new ParseQrCode(s);
		
		QRCode qr = new QRCode(s);
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
		assertEquals("C����������",qrDetails.get(0).getProduct());
		assertEquals(1,qrDetails.get(0).getAmount());
		assertEquals(22,qrDetails.get(0).getSalesAmount());
		
		assertEquals("UQ48655498",qrDetails.get(1).getEinNumber());
		assertEquals(1,qrDetails.get(1).getEncodingID());
		assertEquals("C�i��_�p",qrDetails.get(1).getProduct());
		assertEquals(1,qrDetails.get(1).getAmount());
		assertEquals(28,qrDetails.get(1).getSalesAmount());
	}
	
	
	
}
