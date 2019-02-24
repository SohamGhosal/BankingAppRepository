package com.BankingApp.dao;

import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.dto.User;
import com.BankingApp.exception.BankingException;

public interface ICredentialDAO {
	public String generateNewPassword(User user) throws BankingException;
	public void lockUser(User user) throws BankingException;
	public CustomerRequests verifyCutomer(CustomerRequests cr) throws BankingException;
}
