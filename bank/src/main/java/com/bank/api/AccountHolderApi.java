package com.bank.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.AccountHolder;
import com.bank.service.AccountHolderService;

@RestController
@RequestMapping("/AccountHolderAPI")
public class AccountHolderApi {

	@Autowired
	private Environment environment;
	
	@Autowired
	AccountHolderService accountHolderService;
	
	
	
	@GetMapping("/getAccountHolder/{accountHolderId}")
	public ResponseEntity<AccountHolder> fetchAccountHolder(@PathVariable Integer accountHolderId){
	
		ResponseEntity<AccountHolder> responseEntity=null;
	
		AccountHolder accountHolder=accountHolderService.getAccountHolderByAccountHolderId(accountHolderId);
		
		responseEntity=new ResponseEntity<AccountHolder>(accountHolder, HttpStatus.OK);
		
		
		
		return responseEntity;
		
	
}
	@PostMapping("/addAccountHolder/accountHolder")
	public ResponseEntity<String> addAccountHolder(@RequestBody AccountHolder accountHolder){
		
		ResponseEntity<String> responseEntity=null;
		String message=null;
		
		accountHolderService.addNewAccountHolder(accountHolder);
		message=environment.getProperty("ACCOUNTHOLDER_API.SUCCESSFUL_ADDITION");
		responseEntity=new ResponseEntity<String>(message, HttpStatus.CREATED);
		return responseEntity;
		
	}
	
	@PostMapping("/deleteAccountHolder/{accountHolderId}")
	public ResponseEntity<String> deleteAccountHolder(@PathVariable Integer accountHolderId){
		
		ResponseEntity<String> responseEntity=null;
		String message=null;
		
		accountHolderService.deleteAccountHolder(accountHolderId);
		message=environment.getProperty("ACCOUNTHOLDER_API.SUCCESSFUL_DELETION");
		responseEntity=new ResponseEntity<String>(message, HttpStatus.OK);
		return responseEntity;
	
	}
	
	@PutMapping("updateAccountHolder/accountHolder/{accountHolderId}")
	public ResponseEntity<String> updateAccountHolder(@RequestBody AccountHolder  accountHolder,@PathVariable Integer accountHolderId){
		
		ResponseEntity<String> responseEntity=null;
		String message=null;
		
		accountHolderService.updateAccountHolder(accountHolderId, accountHolder.getEmail());
		
		message=environment.getProperty("ACCOUNTHOLDER_API.SUCCESSFUL_UPDATION");
		responseEntity=new ResponseEntity<String>(message, HttpStatus.OK);
		return responseEntity;
	}
	
}

