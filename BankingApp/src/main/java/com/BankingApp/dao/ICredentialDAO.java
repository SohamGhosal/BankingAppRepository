package com.BankingApp.dao;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.exception.BankingException;

public interface ICredentialDAO {
	public String generateNewPassword(BankUser user) throws BankingException;
	public boolean lockUser(BankUser user) throws BankingException;
	public CustomerRequests verifyCutomer(CustomerRequests cr) throws BankingException;
}
