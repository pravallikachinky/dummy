package com.cg.plp.bean;

import java.time.LocalDate;

public class Account {
	 private String phoneNum;
	 private String custName;
	 private String gender;
	 private double bal;
	 private String emailId;
	 private LocalDate doj;
		public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Account(String phoneNum, String custName, String gender, double bal,
			String emailId, LocalDate doj) {
		super();
		this.phoneNum = phoneNum;
		this.custName = custName;
		this.gender = gender;
		this.bal = bal;
		this.emailId = emailId;
		this.doj = doj;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	}
