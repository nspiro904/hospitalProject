package com.example.demo.api.model;

public class ProcedureRecord {

	String pssn;
	String pnum;
	String pdate;
	String dssn;
	String time;
	String description;
	
	
	public ProcedureRecord(String pssn, String pnum, String pdate) {
		this.pssn = pssn;
		this.pnum = pnum;
		this.pdate = pdate;
	}


	



	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	

	public String getPssn() {
		return pssn;
	}






	public void setPssn(String pssn) {
		this.pssn = pssn;
	}






	public String getPnum() {
		return pnum;
	}






	public void setPnum(String pnum) {
		this.pnum = pnum;
	}






	public String getDssn() {
		return dssn;
	}






	public void setDssn(String dssn) {
		this.dssn = dssn;
	}






	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
}
