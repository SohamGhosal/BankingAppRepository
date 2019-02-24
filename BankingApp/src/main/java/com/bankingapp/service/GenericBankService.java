package com.BankingApp.service;

import com.BankingApp.dao.IGenericBankDAO;
import com.BankingApp.dto.*;
import com.BankingApp.exception.BankingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
