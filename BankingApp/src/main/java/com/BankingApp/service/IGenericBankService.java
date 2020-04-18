package com.BankingApp.service;

import com.BankingApp.dto.*;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IGenericBankService {
	public BankUser getUserDetails(BankUser user) throws BankingException;
	public AccountMaster getAccountDetails(int accid) throws BankingException;
	public List<Transactions> getStatements(int accid) throws BankingException;
	public List<SecurityQuest>getQuestionList() throws BankingException;
	
	public ServiceTracker showServiceByID(Integer serviceId) throws BankingException;
}
