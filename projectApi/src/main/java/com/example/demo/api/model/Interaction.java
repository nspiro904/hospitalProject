package com.example.demo.api.model;

public class Interaction {

	private Patient patient;
	private String id;
	private String date;
	private String description;
	private String time;
	
	public Interaction(Patient p, String id, String date, String description, String time) {
		this.patient = p;
		this.id = id;
		this.date = date;
		this.description = description;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
