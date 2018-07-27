package com.bankingapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapp.dao.IGenericBankDAO;
import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.PayeeTable;
import com.bankingapp.dto.SecurityQuest;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.Transactions;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;

@Service("bankService")
@Transactional
public class GenericBankService implements IGenericBankService {
	
	@Autowired
	IGenericBankDAO bankDao;
	@Override
	public User getUserDetails(User user) throws BankingException
	{
		return bankDao.getUserDetails(user);
	}
	
	@Override
	public AccountMaster getAccountDetails(int accid) throws BankingException
	{
		return bankDao.getAccountDetails(accid);
	}
	
	
	@Override
	public List<Transactions> getStatements(int accid) throws BankingException
	{
		return bankDao.getStatements(accid);  
	}
	
	
	@Override
	public ServiceTracker showServiceByID(ServiceTracker st) throws BankingException
	{
		return bankDao.showServiceByID(st);
	}
	
	
	@Override
	public List<SecurityQuest> getQuestionList() throws BankingException {
		
		return bankDao.getQuestionList();
	}
	
	
	
}
