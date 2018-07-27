package com.bankingapp.dao;
import java.util.List;

import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.BankAdmin;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.PayeeTable;
import com.bankingapp.dto.SecurityQuest;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.Transactions;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;

public interface IGenericBankDAO
{
	public User getUserDetails(User user) throws BankingException;
	public AccountMaster getAccountDetails(int accid) throws BankingException;
	public List<Transactions> getStatements(int accid) throws BankingException;
	public List<SecurityQuest>getQuestionList() throws BankingException;
	public ServiceTracker showServiceByID(ServiceTracker st) throws BankingException;
}
