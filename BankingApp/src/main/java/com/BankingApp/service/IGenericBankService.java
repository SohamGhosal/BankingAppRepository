package com.BankingApp.service;

import com.BankingApp.dto.*;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IGenericBankService {
	public boolean verifyUser(BankUser user) throws BankingException;
	public boolean loginUser(BankUser user) throws BankingException;
	public BankUser getUserDetails(BankUser user) throws BankingException;
	public AccountMaster getAccountDetails(String accid) throws BankingException;
	public List<Transactions> getStatements(String accid) throws BankingException;
	public List<SecurityQuest>getQuestionList() throws BankingException;
	public ServiceTracker showServiceByID(String serviceId) throws BankingException;
}
