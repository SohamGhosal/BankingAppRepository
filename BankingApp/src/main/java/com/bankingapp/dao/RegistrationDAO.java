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
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
import com.bankingapp.util.QueryMapper;
@Repository("registrationDAO")
@Transactional
public class RegistrationDAO implements IRegistrationDAO {
	private static Logger logger=Logger.getLogger(RegistrationDAO.class);
	@PersistenceContext
	EntityManager em;
	@Override
	public boolean registerUser(CustomerRequests cr) throws BankingException {
		boolean res=false;
		try
		{
			em.persist(cr);
			res=true;
			return res;
		}
		catch(PersistenceException e) {
			throw new BankingException("Registration Failed");
		}
	}
	@Override
	public List<CustomerRequests> getCustReqList() throws BankingException {
		TypedQuery<CustomerRequests> query=em.createQuery
				(QueryMapper.getRequests,CustomerRequests.class);
		query.setParameter("status","Open");
		try {
			List<CustomerRequests> custReqList=query.getResultList();
			if(custReqList.size()>0)
				return custReqList;
			else
				throw new BankingException("Customer List is Empty");
		} catch(PersistenceException e) {
			throw new BankingException("Customer List is Empty");
		}
	}
	@Override
	public CustomerRequests getCustReq(Integer customerReqId) throws BankingException {
		try {
			CustomerRequests custReq=em.getReference(CustomerRequests.class, customerReqId);
			return custReq;
		} catch(PersistenceException e) {
			throw new BankingException("Request Not found");
		}
	}
	@Override
	public boolean insertCustomer(AccountMaster acc,User user,Customer cust,CustomerRequests custReq) throws BankingException{
		try
		{
			em.persist(acc);
			em.persist(user);
			em.persist(cust);
			em.merge(custReq);
			logger.info("Registration is Sucessful");
			return true;
		}
		catch(PersistenceException e) {
			throw new BankingException("Insertion Failed");
		}


	}

}
