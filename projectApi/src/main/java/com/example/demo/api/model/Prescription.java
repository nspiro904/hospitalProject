package com.example.demo.api.model;

public class Prescription {

	private String pssn;
	private String medication;
	private String dssn;
	private String date;
	

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}


	
	public Prescription(String pssn, String medication, String dssn, String date) {
		this.pssn = pssn;
		this.medication = medication;
		this.dssn = dssn;
		this.date = date;
	}

	
	public String getPssn() {
		return pssn;
	}

	public void setPssn(String pssn) {
		this.pssn = pssn;
	}

	public String getDssn() {
		return dssn;
	}

	public void setDssn(String dssn) {
		this.dssn = dssn;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
