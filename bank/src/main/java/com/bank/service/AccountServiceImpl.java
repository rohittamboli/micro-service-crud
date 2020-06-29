package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDao;
import com.bank.model.Account;

@Service(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;

	@Override
	public Account getAccountDetailsByAccountId(Integer acccountId) {
		// TODO Auto-generated method stub
		
		Account account=new Account();
		if(acccountId!=null) {
			account=accountDao.getAccountDetailsByAccountId(acccountId);
		}
		return account;
	}

	@Override
	public void addNewAccount(Account account) {
		// TODO Auto-generated method stub
		
		if(account!=null) {
			accountDao.addNewAccount(account);
		}
		
	}

	@Override
	public void deleteAccount(Integer accountId) {
		// TODO Auto-generated method stub
		
		if(accountId!=null) {
			accountDao.deleteAccount(accountId);
		}
		
	}

	@Override
	public void updateAccount(Integer accountId, Integer balance) {
		// TODO Auto-generated method stub
		
		accountDao.updateAccount(accountId, balance);
		
	}

}
