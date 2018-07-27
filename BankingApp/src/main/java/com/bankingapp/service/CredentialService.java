package com.bankingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapp.dao.ICredentialDAO;
import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
@Service("credentialService")
@Transactional
public class CredentialService implements ICredentialService{
	@Autowired
	ICredentialDAO credentialDao;
	@Override
	public String generateNewPassword(User user) throws BankingException
	{
		return credentialDao.generateNewPassword(user);
	}
	@Override
	public void lockUser(User user) throws BankingException
	{
		credentialDao.lockUser(user);
	}
	@Override
	public CustomerRequests verifyCutomer(CustomerRequests cr) throws BankingException {
		return credentialDao.verifyCutomer(cr);
	}
}
