package com.example.demo.api.model;

public class Department {

	String dcode;
	String name;
	String officePhone;
	int officeNumber;
	String officeHead;
	
	public Department(String dcode, String name, String officePhone, int officeNumber, String officeHead) {
		super();
		this.dcode = dcode;
		this.name = name;
		this.officePhone = officePhone;
		this.officeNumber = officeNumber;
		this.officeHead = officeHead;
	}

	public String getDcode() {
		return dcode;
	}

	public void setDcode(String dcode) {
		this.dcode = dcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public int getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getOfficeHead() {
		return officeHead;
	}

	public void setOfficeHead(String officeHead) {
		this.officeHead = officeHead;
	}
	
	
	
}
