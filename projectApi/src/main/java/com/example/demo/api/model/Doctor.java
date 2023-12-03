package com.example.demo.api.model;

import java.sql.Date;

public class Doctor {

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Character getMinit() {
		return minit;
	}

	public void setMinit(Character minit) {
		this.minit = minit;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneContact() {
		return phoneContact;
	}

	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	private String ssn;
	private String did;
	private String fname;
	private Character minit;
	private String lname;
	private String address;
	private String phone;
	private String phoneContact;
	private String bdate;
	private String department;
	
	public Doctor(String ssn, String did, String fname, String lname, String department) {
		this.ssn = ssn;
		this.did = did;
		this.fname = fname;
		this.lname = lname;
		this.department = department;
	}
}
