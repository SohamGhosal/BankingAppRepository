package com.BankingApp.controller;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.service.ICredentialService;
import com.BankingApp.service.IGenericBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/controlcredential")
@Slf4j
public class CredentialController{
	@Autowired
	ICredentialService credentialService;
	@Autowired
	IGenericBankService genericBankService;

	@PostMapping(value="/forgotaccount")
	public ResponseEntity<String> recoverAccount(@RequestBody BankUser bankUser)
	{
		if(genericBankService.verifyUser(bankUser))
			return ResponseEntity.ok().body("Verified Successfully");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Verification Failed");
	}
	@PostMapping(value="/lockuser")
	public ResponseEntity<String> lockUser(@RequestBody BankUser bankUser) {
		try {
			credentialService.lockUser(bankUser);
			return ResponseEntity.ok().body("User Locked");
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Locking Failed");
		}
	}
	@PostMapping(value="/verifycustomer")
	public CustomerRequests verifyCustomer(@RequestBody CustomerRequests customerRequests)
	{
		return credentialService.verifyCustomer(customerRequests);
	}
}
