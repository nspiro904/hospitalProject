package com.example.demo.api.model;

public class Procedure {

	String procNum;
	String name;
	String description;
	String offeredBy;
	int duration;
	
	public Procedure(String procNum, String name, String description, String offeredBy, int duration) {
		super();
		this.procNum = procNum;
		this.name = name;
		this.description = description;
		this.offeredBy = offeredBy;
		this.duration = duration;
	}

	public String getProcNum() {
		return procNum;
	}

	public void setProcNum(String procNum) {
		this.procNum = procNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOfferedBy() {
		return offeredBy;
	}

	public void setOfferedBy(String offeredBy) {
		this.offeredBy = offeredBy;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
}
