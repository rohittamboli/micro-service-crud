package com.bank.dao;

import com.bank.model.Account;

public interface AccountDao {
	public Account getAccountDetailsByAccountId(Integer acccountId);
	
	public void addNewAccount(Account account);
	
	public void deleteAccount(Integer accountId);
	
	
	
	
}
