package com.BankingApp.service;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.exception.BankingException;

public interface ICredentialService {
	public void lockUser(BankUser user) throws BankingException;
	public CustomerRequests verifyCustomer(CustomerRequests cr) throws BankingException;
}
