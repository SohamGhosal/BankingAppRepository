package com.BankingApp.service.impl;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.exception.BankingException;
import com.BankingApp.repository.BankUserRepository;
import com.BankingApp.repository.CustomerRequestsRepository;
import com.BankingApp.service.ICredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("credentialService")
public class CredentialService implements ICredentialService {
	@Autowired
	CustomerRequestsRepository customerRequestsRepository;
	@Autowired
	BankUserRepository bankUserRepository;
	@Override
	public void lockUser(BankUser user) throws BankingException
	{
		user.setLockStatus("Y");
		bankUserRepository.saveAndFlush(user);
	}
	@Override
	public CustomerRequests verifyCustomer(CustomerRequests cr) throws BankingException {
		return customerRequestsRepository.findByStatusAndEmail(cr.getStatus(), cr.getEmail());
	}
}
