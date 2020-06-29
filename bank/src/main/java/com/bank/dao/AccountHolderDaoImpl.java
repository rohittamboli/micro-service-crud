package com.bank.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.entity.AccountHolderEntity;
import com.bank.model.AccountHolder;

@Repository(value = "accountHolderDao")
public class AccountHolderDaoImpl implements AccountHolderDao{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public AccountHolder getAccountHolderByAccountHolderId(Integer accountHolderId) {
		// TODO Auto-generated method stub
		
	
		
		AccountHolderEntity accountHolderEntity=entityManager.find(AccountHolderEntity.class, accountHolderId);
		
	
		AccountHolder accountHolder=new AccountHolder();
		accountHolder.setAccountHolderId(accountHolderId);
		accountHolder.setFirstName(accountHolderEntity.getFirstName());
		accountHolder.setLastName(accountHolderEntity.getLastName());
		accountHolder.setEmail(accountHolderEntity.getEmail());
		accountHolder.setAddress(accountHolderEntity.getAddress());
		
		
		return accountHolder;
	}

	@Override
	public void addNewAccountHolder(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		
		AccountHolderEntity accountHolderEntity=new AccountHolderEntity();
		accountHolderEntity.setAccountHolderId(accountHolder.getAccountHolderId());
		accountHolderEntity.setFirstName(accountHolder.getFirstName());
		accountHolderEntity.setLastName(accountHolder.getLastName());
		accountHolderEntity.setEmail(accountHolder.getEmail());
		accountHolderEntity.setAddress(accountHolder.getAddress());
		
		entityManager.persist(accountHolderEntity);
		
	}

	@Override
	public void deleteAccountHolder(Integer accountHolderId) {
		// TODO Auto-generated method stub
		
		AccountHolderEntity accountHolderEntity=entityManager.find(AccountHolderEntity.class, accountHolderId);
		entityManager.remove(accountHolderEntity);
	}

}
