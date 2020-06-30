package com.bank.dao;

import com.bank.model.Account;

public interface AccountDao {
	public Account getAccountDetailsByAccountId(Integer acccountId);
	
	public void addNewAccount(Account account);
	
	public void deleteAccount(Integer accountId);
	
	public void updateAccount(Integer accountId,Account account);
	
	
	public void patchAccount(Integer accountId,Integer balance);
	
}
