package com.bank.dao;

import com.bank.model.AccountHolder;

public interface AccountHolderDao {

	public AccountHolder getAccountHolderByAccountHolderId(Integer accountHolderId);
	
	public void addNewAccountHolder(AccountHolder accountHolder);
	
	public void deleteAccountHolder(Integer accountHolderId);
}
