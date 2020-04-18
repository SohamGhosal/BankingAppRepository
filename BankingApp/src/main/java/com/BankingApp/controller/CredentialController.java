package com.BankingApp.controller;

import com.BankingApp.dto.BankUser;
import com.BankingApp.service.ICredentialService;
import com.BankingApp.service.IGenericBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ControlCredential")
@Slf4j
public class CredentialController{
	@Autowired
	ICredentialService credentialService;
	@Autowired
	IGenericBankService genericBankService;

	@PostMapping(value="/ForgotAccount")
	public BankUser recoverAccount(@RequestBody BankUser bankUser)
	{
		return genericBankService.getUserDetails(bankUser);

	}
	@PostMapping(value ="/generatePassword")
	public String generatePassword(@RequestBody BankUser bankUser) {
		return credentialService.generateNewPassword(bankUser);
	}

	@PostMapping(value="/lockUser")
	public boolean lockUser(@RequestBody BankUser bankUser) {
		return credentialService.lockUser(bankUser);
	}

}
