package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.entity.AccountEntity;
import com.bank.entity.AccountHolderEntity;
import com.bank.model.Account;
import com.bank.model.AccountHolder;


@Repository(value = "acoountHolderDao")
public class AccountDaoImpl implements AccountDao{

	
	@Autowired
	EntityManager entityManager;
	
	
	@Override
	public Account getAccountDetailsByAccountId(Integer accountId) {
		// TODO Auto-generated method stub
		
		AccountEntity accountEntity=entityManager.find(AccountEntity.class, accountId);
		
		Account account=new Account();
		
		account.setAccountId(accountEntity.getAccountId());
		account.setAccountNumber(accountEntity.getAccountNumber());
		account.setBalance(accountEntity.getBalance());
		
		
		return account;
	}

	@Override
	public void addNewAccount(Account account) {
		// TODO Auto-generated method stub
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setAccountId(account.getAccountId());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setAccountNumber(account.getBalance());

		entityManager.persist(accountEntity);
		
	}

	@Override
	public void deleteAccount(Integer accountId) {
		// TODO Auto-generated method stub
		AccountEntity accountEntity=entityManager.find(AccountEntity.class, accountId);
		entityManager.remove(accountEntity);
	}

}
