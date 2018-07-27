package com.bankingapp.service;

import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;

public interface ICredentialService {
	public String generateNewPassword(User user) throws BankingException;
	public void lockUser(User user) throws BankingException;
	public CustomerRequests verifyCutomer(CustomerRequests cr) throws BankingException;
}
