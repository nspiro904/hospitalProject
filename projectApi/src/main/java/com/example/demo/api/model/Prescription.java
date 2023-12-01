package com.example.demo.api.model;

public class Prescription {

	private Patient patient;
	private String medication;
	private Doctor prescriber;
	private String date;
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public Doctor getPrescriber() {
		return prescriber;
	}

	public void setPrescriber(Doctor prescriber) {
		this.prescriber = prescriber;
	}

	public Prescription(Patient patient, String medication, String date) {
		this.patient = patient;
		this.medication = medication;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
