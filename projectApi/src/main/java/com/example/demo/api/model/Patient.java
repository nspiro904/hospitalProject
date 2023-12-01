package com.example.demo.api.model;


public class Patient {

	private String ssn;
	private String id;
	private String fname;
	private Character minit;
	private String lname;
	private String addressCurrent;
	private String phoneCurrent;
	private String addressPermanent;
	private String phonePermanent;
	private String condition;
	private String bdate;
	private String sex;
	private String docPrimary;
	private String docSecondary;
	
	public Patient(String ssn, String id, String fname, String lname) {
		this.setSsn(ssn);
		this.setId(id);
		this.setFname(fname);
		this.setLname(lname);
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAddressCurrent() {
		return addressCurrent;
	}

	public void setAddressCurrent(String addressCurrent) {
		this.addressCurrent = addressCurrent;
	}

	public String getPhoneCurrent() {
		return phoneCurrent;
	}

	public void setPhoneCurrent(String phoneCurrent) {
		this.phoneCurrent = phoneCurrent;
	}

	public String getAddressPermanent() {
		return addressPermanent;
	}

	public void setAddressPermanent(String addressPermanent) {
		this.addressPermanent = addressPermanent;
	}

	public String getPhonePermanent() {
		return phonePermanent;
	}

	public void setPhonePermanent(String phonePermanent) {
		this.phonePermanent = phonePermanent;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDocPrimary() {
		return docPrimary;
	}

	public void setDocPrimary(String docPrimary) {
		this.docPrimary = docPrimary;
	}

	public String getDocSecondary() {
		return docSecondary;
	}

	public void setDocSecondary(String docSecondary) {
		this.docSecondary = docSecondary;
	}
}
