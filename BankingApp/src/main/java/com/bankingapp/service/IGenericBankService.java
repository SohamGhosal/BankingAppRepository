package com.bankingapp.service;

import java.util.List;

import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.SecurityQuest;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.Transactions;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;

public interface IGenericBankService {
	public User getUserDetails(User user) throws BankingException;
	public AccountMaster getAccountDetails(int accid) throws BankingException;
	public List<Transactions> getStatements(int accid) throws BankingException;
	public List<SecurityQuest>getQuestionList() throws BankingException;
	
	public ServiceTracker showServiceByID(ServiceTracker st) throws BankingException;
}
