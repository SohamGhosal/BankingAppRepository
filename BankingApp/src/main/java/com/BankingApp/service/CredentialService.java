package com.BankingApp.service;

import com.BankingApp.dao.ICredentialDAO;
import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.exception.BankingException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("credentialService")
@Transactional
public class CredentialService implements ICredentialService{
	@Autowired
	ICredentialDAO credentialDao;
	@Override
	public String generateNewPassword(BankUser user) throws BankingException
	{
		user.setPassword(BCrypt.hashpw(RandomStringUtils.randomAlphanumeric(6,6),BCrypt.gensalt()));
		return credentialDao.generateNewPassword(user);
	}
	@Override
	public boolean lockUser(BankUser user) throws BankingException
	{
		user.setLockStatus("Y");
		return credentialDao.lockUser(user);
	}
	@Override
	public CustomerRequests verifyCutomer(CustomerRequests cr) throws BankingException {
		return credentialDao.verifyCutomer(cr);
	}
}
