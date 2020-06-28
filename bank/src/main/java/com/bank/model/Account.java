package com.bank.model;

import java.util.List;

public class Account {
	
	//private Integer accountHolderId;
	private Integer accountId;
	private Integer balance;
	private List<AccountHolder> accountHolders;
	
	
	
	public List<AccountHolder> getAccountHolders() {
		return accountHolders;
	}
	public void setAccountHolders(List<AccountHolder> accountHolders) {
		this.accountHolders = accountHolders;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	

}
