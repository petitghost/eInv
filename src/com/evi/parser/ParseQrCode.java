package com.evi.parser;

import java.util.ArrayList;

import com.evi.model.QRCode;
import com.evi.model.Qdetail;

public class ParseQrCode {
	private QRCode qr;
	private ArrayList<Qdetail> qrDetails;
	
	public ParseQrCode(String s) {
		setQr(new QRCode(s));
		setQrDetails(s);
		
	}

	public QRCode getQr() {
		return qr;
	}

	private void setQr(QRCode qr) {
		this.qr = qr;
	}

	public ArrayList<Qdetail> getQrDetail() {
		return qrDetails;
	}

	private void setQrDetails(String s) {
		qrDetails=new ArrayList<Qdetail>();
		
		String[] details = s.split(":");
		
		int count= (details.length-5)/3;
		//System.out.println(count);
		for(int i=0;i<count;i++) {
			
			qrDetails.add(new Qdetail(details[0].substring(0,10),
					i+1+"",
					Integer.parseInt(details[4]), 
					details[5+(i*3)], 
					Integer.parseInt(details[6+(i*3)]), 
					Integer.parseInt(details[7+(i*3)])));
		}
		
	}
}
