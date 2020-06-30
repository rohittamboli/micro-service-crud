package com.bank.dao;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.entity.AccountEntity;
import com.bank.entity.AccountHolderEntity;
import com.bank.model.Account;
import com.bank.model.AccountHolder;

@Repository(value = "accountHolderDao")
public class AccountHolderDaoImpl implements AccountHolderDao{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public AccountHolder getAccountHolderByAccountHolderId(Integer accountHolderId) {
		// TODO Auto-generated method stub
		
		List<AccountEntity> accountEntities=new ArrayList<AccountEntity>();
		
		List<Account> accountList=new ArrayList<Account>();
		AccountHolderEntity accountHolderEntity=entityManager.find(AccountHolderEntity.class, accountHolderId);
		
	
		AccountHolder accountHolder=new AccountHolder();
		accountHolder.setAccountHolderId(accountHolderId);
		accountHolder.setFirstName(accountHolderEntity.getFirstName());
		accountHolder.setLastName(accountHolderEntity.getLastName());
		accountHolder.setEmail(accountHolderEntity.getEmail());
		accountHolder.setAddress(accountHolderEntity.getAddress());
		
		accountEntities=accountHolderEntity.getAccountEntities();
		
		for(AccountEntity accountEntity:accountEntities) {
			Account account=new Account();
			account.setAccountId(accountEntity.getAccountId());
			account.setAccountNumber(accountEntity.getAccountId());
			account.setBalance(accountEntity.getBalance());
			
			accountList.add(account);
			}
		accountHolder.setAccounts(accountList);
		return accountHolder;
	}

	@Override
	public void addNewAccountHolder(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		
		List<AccountEntity> accountEntities=new ArrayList<AccountEntity> ();
		
		List<Account> accountList=new ArrayList<Account>();
		
		AccountHolderEntity accountHolderEntity=new AccountHolderEntity();
		//accountHolderEntity.setAccountHolderId(accountHolder.getAccountHolderId());
		accountHolderEntity.setFirstName(accountHolder.getFirstName());
		accountHolderEntity.setLastName(accountHolder.getLastName());
		accountHolderEntity.setEmail(accountHolder.getEmail());
		accountHolderEntity.setAddress(accountHolder.getAddress());
		
		accountList=accountHolder.getAccounts();
		
		for(Account account:accountList) {
			AccountEntity accountEntity=new AccountEntity();
			//accountEntity.setAccountId(account.getAccountId());
			accountEntity.setAccountNumber(account.getAccountNumber());
			accountEntity.setBalance(account.getBalance());
			
			
			accountEntities.add(accountEntity);
		}
		accountHolderEntity.setAccountEntities(accountEntities);
		
		entityManager.persist(accountHolderEntity);
		
	}

	@Override
	public void deleteAccountHolder(Integer accountHolderId) {
		// TODO Auto-generated method stub
		
		AccountHolderEntity accountHolderEntity=entityManager.find(AccountHolderEntity.class, accountHolderId);
		entityManager.remove(accountHolderEntity);
	}

	@Override
	public void updateAccountHolder(Integer accountHolderId,AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		
		List<AccountEntity> accountEntities=new ArrayList<AccountEntity> ();
		
		List<Account> accountList=new ArrayList<Account>();
		AccountHolderEntity accountHolderEntity=entityManager.find(AccountHolderEntity.class, accountHolderId);
		accountHolderEntity.setFirstName(accountHolder.getFirstName());
		accountHolderEntity.setLastName(accountHolder.getLastName());
		accountHolderEntity.setEmail(accountHolder.getEmail());
		accountHolderEntity.setAddress(accountHolder.getAddress());
		
		accountList=accountHolder.getAccounts();
		
		for(Account account:accountList) {
			AccountEntity accountEntity=new AccountEntity();
			//accountEntity.setAccountId(account.getAccountId());
			accountEntity.setAccountNumber(account.getAccountNumber());
			accountEntity.setBalance(account.getBalance());
			
			
			accountEntities.add(accountEntity);
		}
		accountHolderEntity.setAccountEntities(accountEntities);
	}

	@Override
	public void patchAccountHolder(Integer accountHolderId, AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		AccountHolderEntity accountHolderEntity=entityManager.find(AccountHolderEntity.class, accountHolderId);
		accountHolderEntity.setEmail(accountHolder.getEmail());

	}

}
