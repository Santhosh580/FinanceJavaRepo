package com.lti.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customer1")
public class Customer {


	@Id
	@SequenceGenerator(name="custSeq",initialValue=3001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="custSeq")
	int customerId;
	String customerName;
	String phoneNumber;
	String userName;
	String password;
	String selectBank;
	String ifscCode;
	boolean accept = true;
	
	@OneToOne(mappedBy="Customer")
	Card card;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSelectBank() {
		return selectBank;
	}
	public void setSelectBank(String selectBank) {
		this.selectBank = selectBank;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public boolean isAccept() {
		return accept;
	}
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	
}
