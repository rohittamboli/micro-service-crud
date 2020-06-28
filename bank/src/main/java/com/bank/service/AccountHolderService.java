package com.bank.service;

import com.bank.model.AccountHolder;

public interface AccountHolderService {
	public AccountHolder getAccountHolderByAccountHolderId(Integer accountHolderId);
	
	public void addNewAccountHolder(AccountHolder accountHolder);
	
	public void deleteAccountHolder(Integer accountHolderId);
}
