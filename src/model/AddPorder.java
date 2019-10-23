package model;

import parse.Wes2Chi;

public class AddPorder {
	private String einnumber;
	private String eindate;
	private String sortName;
	private int sourceId;
	private int sortId;
	private int UID;
	private int totalprice;
	private String note;
	
	public AddPorder(String sortName,int sortID,int UID,int totalprice,String einnumber,String eindate,String note)
	{
		setEinnumber(einnumber);
		setEindate(eindate);
		setSortName(sortName);
		//setSourceID(sourceID);
		setSortID(sortID);
		setUID(UID);
		setTotalprice(totalprice);	
		setNote(note);
	}
	
//	public AddPorder(int sourceID,int sortID,int UID,int totalprice,String einnumber,String eindate,String note)
//	{
//		setEinnumber(einnumber);
//		setEindate(eindate);
//		setSourceID(sourceID);
//		setSortID(sortID);
//		setUID(UID);
//		setTotalprice(totalprice);	
//		setNote(note);
//	}
	
	public AddPorder(String s) {
		setEinnumber(s.substring(0,10));
		setEindate(Wes2Chi.parse(s.substring(10,17)));
		setSourceID(1);
		setSortID(0);
		setUID(1111);
		setTotalprice(s.substring(29,37));	
	}
	
	public AddPorder(String[] details) {
		setEinnumber(details[6]);
		setEindate(details[3]);
		setSourceID(2);
		setSortID(0);
		setUID(1111);
		setTotalprice(Integer.parseInt(details[7]));
	
	}


	public int getSourceId() {
		return sourceId;
	}
	private void setSourceID(int sourceID) {
		this.sourceId = sourceID;
	}
	public int getSortId() {
		return sortId;
	}
	private void setSortID(int sortID) {
		this.sortId = sortID;
	}
	public int getUID() {
		return UID;
	}
	private void setUID(int uID) {
		UID = uID;
	}
	public int getTotalprice() {
		return totalprice;
	}
	private void setTotalprice(String totalprice) {		
		this.totalprice = Integer.parseInt( totalprice, 16 );
	}
	private void setTotalprice(int totalprice) {		
		this.totalprice = totalprice;
	}
	public String getEinnumber() {
		return einnumber;
	}
	private void setEinnumber(String einnumber) {
		this.einnumber = einnumber;
	}
	public String getEindate() {
		String[] details = eindate.split(" "); 
		return details[0];
	}
	private void setEindate(String eindate) {
		this.eindate = eindate;
	}
	public String getNote() {
		return note;
	}
	private void setNote(String note) {
		this.note = note;
	}

	public String getSortName() {
		return sortName;
	}

	private void setSortName(String sortName) {
		this.sortName = sortName;
	}



}
