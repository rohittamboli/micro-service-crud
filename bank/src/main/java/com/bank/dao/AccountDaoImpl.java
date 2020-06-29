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
		List<AccountHolderEntity> accountHolderEntities=null;
		
		List<AccountHolder> accountHolders=new ArrayList<AccountHolder>();
		AccountEntity accountEntity=entityManager.find(AccountEntity.class, accountId);
		
		Account account=new Account();
		
//		accountEntity.setAccountId(accountEntity.getAccountId());
//		accountEntity.setBalance(accountEntity.getBalance());
//		
		accountHolderEntities=accountEntity.getAccountHolderEntities();
		
		for(AccountHolderEntity accountHolderEntity:accountHolderEntities) {
			AccountHolder accountHolder=new AccountHolder();
			accountHolder.setAccountHolderId(accountHolderEntity.getAccountHolderId());
			accountHolder.setFirstName(accountHolderEntity.getFirstName());
			accountHolder.setLastName(accountHolderEntity.getLastName());
			accountHolder.setEmail(accountHolderEntity.getEmail());
			accountHolder.setAddress(accountHolderEntity.getAddress());
			
			accountHolders.add(accountHolder);
			
		}
//		accountEntity.setAccountHolderEntities(accountHolderEntities);
		
		
		account.setAccountId(accountEntity.getAccountId());
		
		account.setBalance(accountEntity.getBalance());
		
		account.setAccountHolders(accountHolders);
		return account;
	}

	@Override
	public void addNewAccount(Account account) {
		// TODO Auto-generated method stub
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setAccountId(account.getAccountId());
		accountEntity.setBalance(accountEntity.getBalance());
		
		List<AccountHolder>accountHolders=account.getAccountHolders();
		
		List<AccountHolderEntity> accountHolderEntities=new ArrayList<AccountHolderEntity>();
		
		
		for(AccountHolder accountHolder:accountHolders) {
			AccountHolderEntity accountHolderEntity=new AccountHolderEntity();
			accountHolderEntity.setAccountHolderId(accountHolder.getAccountHolderId());
			accountHolderEntity.setFirstName(accountHolder.getFirstName());
			accountHolderEntity.setLastName(accountHolder.getLastName());
			accountHolderEntity.setEmail(accountHolder.getEmail());
			accountHolderEntity.setAddress(accountHolder.getAddress());
		
			accountHolderEntities.add(accountHolderEntity);
		}
		accountEntity.setAccountHolderEntities(accountHolderEntities);
	}

	@Override
	public void deleteAccount(Integer accountId) {
		// TODO Auto-generated method stub
		AccountEntity accountEntity=entityManager.find(AccountEntity.class, accountId);
		entityManager.remove(accountEntity);
	}

}
