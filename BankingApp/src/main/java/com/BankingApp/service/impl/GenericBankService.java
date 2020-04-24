package com.BankingApp.service.impl;

import com.BankingApp.dto.*;
import com.BankingApp.exception.BankingException;
import com.BankingApp.repository.*;
import com.BankingApp.service.IGenericBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bankService")
public class GenericBankService implements IGenericBankService {
	@Autowired
	private BankUserRepository bankUserRepository;
	@Autowired
	private ServiceTrackerRepository serviceTrackerRepository;
	@Autowired
	private AccountMasterRepository accountMasterRepository;
	@Autowired
	private TransactionsRepository transactionsRepository;
	@Autowired
	private SecurityQuestRepository securityQuestRepository;
	@Override
	public boolean verifyUser(BankUser user) throws BankingException {
		return bankUserRepository.existsById(user.getUserId());
	}

	@Override
	public boolean loginUser(BankUser user) throws BankingException {
		if(verifyUser(user))
			return BCrypt.checkpw(user.getPassword(),getUserDetails(user).getPassword());
			return false;
	}

	@Override
	public BankUser getUserDetails(BankUser user) throws BankingException
	{
		 return bankUserRepository.findById(user.getUserId()).get();
	}
	
	@Override
	public AccountMaster getAccountDetails(String accid) throws BankingException
	{
		return accountMasterRepository.findById(accid).get();
	}
	
	
	@Override
	public List<Transactions> getStatements(String accid) throws BankingException
	{
		return transactionsRepository.findByAccountNo(accid);
	}
	
	
	@Override
	public ServiceTracker showServiceByID(String serviceId) throws BankingException
	{
		return serviceTrackerRepository.findById(serviceId).get();
	}

	@Override
	public List<SecurityQuest> getQuestionList() throws BankingException {
		
		return securityQuestRepository.findAll();
	}
}
