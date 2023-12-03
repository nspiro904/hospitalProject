package com.example.demo.api.model;

public class ProcedureRecord {

	Patient patient;
	Procedure procedure;
	String pdate;
	Doctor doctor;
	String time;
	String description;
	
	public ProcedureRecord(Patient patient, Procedure procedure, String pdate, Doctor doctor, String time,
			String description) {
		this.patient = patient;
		this.procedure = procedure;
		this.pdate = pdate;
		this.doctor = doctor;
		this.time = time;
		this.description = description;
	}


	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public Procedure getProcedure(){
		return procedure;
	}

	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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


	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
}
