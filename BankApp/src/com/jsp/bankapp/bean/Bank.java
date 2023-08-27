package com.jsp.bankapp.bean;

import java.io.Serializable;

public class Bank implements Serializable{

	private int custId;
	private long AccountNumber;
	private String bankName;
	private String accountHolderName;
	private String custAddress;
	private long custPhoneNumber;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public long getCustPhoneNumber() {
		return custPhoneNumber;
	}
	public void setCustPhoneNumber(long custPhoneNumber) {
		this.custPhoneNumber = custPhoneNumber;
	}
	
}
