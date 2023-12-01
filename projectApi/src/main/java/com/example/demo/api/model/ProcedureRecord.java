package com.example.demo.api.model;

public class ProcedureRecord {

	Patient patient;
	String pname;
	String pdate;
	
	public ProcedureRecord(Patient patient, String pname, String pdate) {
		this.patient = patient;
		this.pname = pname;
		this.pdate = pdate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getProcedure() {
		return pname;
	}

	public void setProcedure(String pname) {
		this.pname = pname;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
}
