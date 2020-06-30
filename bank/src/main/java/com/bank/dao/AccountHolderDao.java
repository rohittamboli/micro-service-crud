package com.bank.dao;

import com.bank.model.AccountHolder;

public interface AccountHolderDao {

	public AccountHolder getAccountHolderByAccountHolderId(Integer accountHolderId);
	
	public void addNewAccountHolder(AccountHolder accountHolder);
	
	public void deleteAccountHolder(Integer accountHolderId);
	
	public void updateAccountHolder(Integer accountHolderId,AccountHolder accountHolder);
	
	public void patchAccountHolder(Integer accountHolderId,AccountHolder accountHolder);
}
