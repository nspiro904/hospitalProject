package com.example.demo.api.model;

public class Medication {
	
	String name;
	String manufacturer;
	String description;
	
	public Medication(String name, String manufacturer, String description) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
