package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountHolderDao;
import com.bank.model.AccountHolder;


@Service(value = "accountHolderService")
@Transactional
public class AccountHolderServiceImpl implements AccountHolderService{

	
	@Autowired
	private AccountHolderDao accountHolderDao;  
	
	@Override
	public AccountHolder getAccountHolderByAccountHolderId(Integer accountHolderId) {
		// TODO Auto-generated method stub
	
		
		AccountHolder accountHolder = new AccountHolder();
		if(accountHolderId!=null) {
			accountHolder=accountHolderDao.getAccountHolderByAccountHolderId(accountHolderId);
		}
		
		
		return accountHolder;
	}

	@Override
	public void addNewAccountHolder(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		if(accountHolder!=null)
		accountHolderDao.addNewAccountHolder(accountHolder);
		
	}

	@Override
	public void deleteAccountHolder(Integer accountHolderId) {
		// TODO Auto-generated method stub
		
		if(accountHolderId!=null)
			accountHolderDao.deleteAccountHolder(accountHolderId);
	}

}
