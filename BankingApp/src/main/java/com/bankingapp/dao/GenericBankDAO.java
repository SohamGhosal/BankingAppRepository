package com.bankingapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.SecurityQuest;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.Transactions;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
import com.bankingapp.util.QueryMapper;

@Repository("bankDao")
@Transactional
public class GenericBankDAO implements IGenericBankDAO
{
	private static Logger logger=Logger.getLogger(GenericBankDAO.class);
	@PersistenceContext
	EntityManager em;
	
	@Override
	public User getUserDetails(User user) throws BankingException
	{
		TypedQuery<User> query;
		if(user.getPassword()==null)
		{
			query=em.createQuery(QueryMapper.validateUser,User.class);
			query.setParameter("uid",user.getUserId());
			query.setParameter("lock", "N");
		}
		else
		{
			query=em.createQuery(QueryMapper.getUser,User.class);
			query.setParameter("uid",user.getUserId());
			query.setParameter("password", user.getPassword());
			query.setParameter("lock", "N");
		}
		try
		{
			user = query.getSingleResult();
			logger.info("User is validated!");
		}
		catch(PersistenceException e)
		{
			throw new BankingException("Invalid Credential");
		}
		return user;
	}

	@Override
	public AccountMaster getAccountDetails(int accid) throws BankingException
	{
		try
		{
			AccountMaster am=em.getReference(AccountMaster.class, accid);
			return am;
		}
		catch(PersistenceException e)
		{
			throw new BankingException("Account Id does not exist");
		}
	}

	
	

	

	@Override
	public List<Transactions> getStatements(int accid) throws BankingException
	{
		TypedQuery<Transactions> query=em.createQuery(QueryMapper.getTransactions,Transactions.class);
		query.setParameter("accid",accid);
		List<Transactions> transactionLogs;
		try {
			transactionLogs = query.getResultList();
			if(transactionLogs.size()>0)
				return transactionLogs;
			else
				throw new BankingException("No records found");
		} catch(PersistenceException e) {
			throw new BankingException("No records found");
		}

	}
	
	

	

	@Override
	public List<SecurityQuest> getQuestionList() throws BankingException {
		TypedQuery<SecurityQuest> query=em.createQuery
				("FROM SecurityQuest",SecurityQuest.class);
		List<SecurityQuest> list;
		try {
			list = query.getResultList();
			return list;
		} catch(PersistenceException e) {
			throw new BankingException("List fetching unsuccessful");
		}

	}

	@Override
	public ServiceTracker showServiceByID(ServiceTracker st) throws BankingException
	{
		try {
			ServiceTracker sts = em.getReference(ServiceTracker.class, st.getServiceId());
			return sts;
		} catch(PersistenceException e) {
			throw new BankingException("No records found");
		}

	}
}
