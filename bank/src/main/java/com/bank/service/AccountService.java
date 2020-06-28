package com.bank.service;

import com.bank.model.Account;

public interface AccountService {
	public Account getAccountDetailsByAccountId(Integer acccountId);
	
	public void addNewAccount(Account account);
	
	public void deleteAccount(Integer accountId);
	
}
