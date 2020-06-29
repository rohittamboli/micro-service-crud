package com.bank.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACCOUNT_ID")
	private Integer accountId;
	
	@Column(name="BALANCE")
	private Integer balance;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_HOLDER_ID")
	private List<AccountHolderEntity> accountHolderEntities;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public List<AccountHolderEntity> getAccountHolderEntities() {
		return accountHolderEntities;
	}

	public void setAccountHolderEntities(List<AccountHolderEntity> accountHolderEntities) {
		this.accountHolderEntities = accountHolderEntities;
	}

}
