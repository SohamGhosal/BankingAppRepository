package com.BankingApp.dao;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.exception.BankingException;
import com.BankingApp.util.QueryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("userDao")
@Transactional
@Slf4j
public class UserDAO implements IUserDAO {
	@PersistenceContext
	EntityManager em;
	@Override
	public Customer getCustomerDetails(BankUser user) throws BankingException
	{
		TypedQuery<Customer> query=em.createQuery(QueryMapper.getCustomer,Customer.class);
		query.setParameter("accountId", user.getAccId());
		Customer cs=new Customer();
		try
		{
			cs=query.getSingleResult();
		}
		catch(PersistenceException e)
		{
			throw new BankingException("Customer Not Found");
		}
		return cs;
	}
	@Override
	public BankUser changePassword(BankUser us) throws BankingException
	{
		try
		{
			TypedQuery<BankUser> query=em.createQuery(QueryMapper.checkUser,BankUser.class);
			query.setParameter("pwd",us.getPassword());
			query.setParameter("uid",us.getUserId());
			BankUser user=query.getSingleResult();
			user.setPassword(us.getTransPassword());
			em.merge(user);
			em.flush();
			em.getReference(BankUser.class, us.getUserId());
			log.info("Password has been changed successfully");
			return user;
		}
		catch(PersistenceException e)
		{
			throw new BankingException("Password has not been changed successfully");
		}
	}
	@Override
	public Customer updateDetails(Customer cus) throws BankingException {
		try {
			em.merge(cus);
			Customer cust=em.find(Customer.class,cus.getCustomerId());
			return cust;
		} catch(PersistenceException e) {
			throw new BankingException("Update Failed");
		}

	}

	@Override
	public ServiceTracker addCheckRequest(ServiceTracker serviceTracker) throws BankingException
	{
		try
		{
			em.persist(serviceTracker);
			em.flush();
			return em.find(ServiceTracker.class,serviceTracker.getAccId());
		} catch(PersistenceException e) {
			throw new BankingException("Request Failed");
		}
	}

	
	@Override
	public List<ServiceTracker> showServiceByAccID(int accid) throws BankingException
	{
		TypedQuery<ServiceTracker> query=em.createQuery(QueryMapper.getMultipleServcie,ServiceTracker.class);
		query.setParameter("accountid",accid);
		try {
			List<ServiceTracker> serviceLogs=query.getResultList();
			if(serviceLogs.size()>0)
				return serviceLogs;
			else
				throw new BankingException("No records found!");
		} catch(PersistenceException e) {
			throw new BankingException("No records found!");
		}
	}

	@Override
	public boolean checkPendingRequest(int accid) throws BankingException{
		TypedQuery<ServiceTracker> query=em.createQuery(QueryMapper.findRequest,ServiceTracker.class);
		query.setParameter("accountid", accid);
		String servdesc="Request For CheckBook";
		String status="Open";
		query.setParameter("servdesc",servdesc);
		query.setParameter("status",status);
		try {
			ServiceTracker st =query.getSingleResult();
			return true;
		} catch(PersistenceException e) {
			return false;
		}

	}

}
