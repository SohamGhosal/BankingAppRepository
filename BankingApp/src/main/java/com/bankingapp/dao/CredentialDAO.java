package com.bankingapp.dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
import com.bankingapp.util.QueryMapper;
@Repository("credentialDao")
@Transactional
public class CredentialDAO implements ICredentialDAO{
	private static Logger logger=Logger.getLogger(CredentialDAO.class);
	@PersistenceContext
	EntityManager em;
	@Override
	public String generateNewPassword(User user) throws BankingException {
		String uuid = UUID.randomUUID().toString();
		String pass=uuid.substring(0, 4)+"#";
		try {
			user.setPassword(pass);
			em.merge(user);
			em.flush();
			logger.info("Password is changed!");
		} catch(PersistenceException e) {
			throw new BankingException("Password Not changed!");
		}
		return pass;
	}
	@Override
	public void lockUser(User user) throws BankingException
	{
		try
		{
			user.setLockStatus("Y");
			em.merge(user);
			em.flush();
		}

		catch(PersistenceException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public CustomerRequests verifyCutomer(CustomerRequests cr) throws BankingException
	{
		String queryStr=QueryMapper.getRequests;
		queryStr.concat("and email=:email");
		TypedQuery<CustomerRequests>query=em.createQuery(queryStr,CustomerRequests.class);
		try
		{
			CustomerRequests crs=query.getSingleResult();
			return cr;
		}
		catch(PersistenceException e) {
			throw new BankingException("Customer Request Not found");
		}
	}
}
