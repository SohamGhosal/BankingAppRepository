package com.BankingApp.service;

import com.BankingApp.dao.ICredentialDAO;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.dto.User;
import com.BankingApp.exception.BankingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
