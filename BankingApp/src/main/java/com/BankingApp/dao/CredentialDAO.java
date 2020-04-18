package com.BankingApp.dao;

import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.dto.User;
import com.BankingApp.exception.BankingException;
import com.BankingApp.util.QueryMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository("credentialDao")
@Transactional
@Slf4j
public class CredentialDAO implements ICredentialDAO{
	@PersistenceContext
	EntityManager em;
	@Override
	public String generateNewPassword(User user) throws BankingException {
		String pass= RandomStringUtils.randomAlphanumeric(6,6)+"#";
		try {
			user.setPassword(pass);
			em.merge(user);
			em.flush();
			log.info("Password is changed!");
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
			return crs;
		}
		catch(PersistenceException e) {
			throw new BankingException("Customer Request Not found");
		}
	}
}
