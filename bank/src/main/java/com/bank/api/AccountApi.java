package com.bank.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;

import com.bank.service.AccountService;

@RestController
@RequestMapping("/AccountAPI")
public class AccountApi {

	@Autowired
	private Environment environment;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/getAccount/{accountId}")
	public ResponseEntity<Account> fetchAccountHolder(@PathVariable Integer accountId){
		ResponseEntity<Account> responseEntity=null;
		
		Account account=accountService.getAccountDetailsByAccountId(accountId);
		responseEntity=new ResponseEntity<Account>(account, HttpStatus.OK);
		
		return responseEntity;
	
	}
	
	@PostMapping("/addAccount/Account")
	public ResponseEntity<String> addAccountHolder(@RequestBody Account account){
	
		ResponseEntity<String> responseEntity=null;
		String message=null;
		
		accountService.addNewAccount(account);
		
		message=environment.getProperty("ACCOUNT_API.SUCCESSFUL_ADDITION");
		responseEntity=new ResponseEntity<String>(message, HttpStatus.CREATED);
		
		return responseEntity;
	}
	
	@PostMapping("/deleteAccount/{AccountId}")
	public ResponseEntity<String> deleteAccountHolder(@PathVariable Integer accountId){
	
		ResponseEntity<String> responseEntity=null;
		String message=null;
		
		accountService.deleteAccount(accountId);
		
		message=environment.getProperty("ACCOUNT_API.SUCCESSFUL_DELETION");
		responseEntity=new ResponseEntity<String>(message, HttpStatus.OK);
		
		return responseEntity;
	}
	
	
	}
