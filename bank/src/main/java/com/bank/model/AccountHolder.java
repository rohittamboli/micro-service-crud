package com.bank.model;

import java.util.List;


public class AccountHolder {

	private Integer accountHolderId;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	
	private List<Account> accounts;


	public Integer getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(Integer accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
	
}
