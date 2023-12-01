package com.example.demo.api.model;

public class HealthRecord {

	private Patient patient;
	private Object[] scripts;
	private Object[] interactions;
	private Object[] procedures;
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Object[] getScripts() {
		return scripts;
	}

	public void setScripts(Object[] scripts) {
		this.scripts = scripts;
	}

	public Object[] getInteractions() {
		return interactions;
	}

	public void setInteractions(Interaction[] interactions) {
		this.interactions = interactions;
	}

	public Object[] getProcedures() {
		return procedures;
	}

	public void setProcedures(Procedure[] procedures) {
		this.procedures = procedures;
	}

	public HealthRecord(Patient p, Object[] scripts, Object[] interactions, Object[] procedures) {
		patient = p;
		this.scripts = scripts;
		this.interactions = interactions;
		this.procedures = procedures;
	}
}
