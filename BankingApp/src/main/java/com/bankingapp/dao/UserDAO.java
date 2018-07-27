package com.bankingapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bankingapp.dto.Customer;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
import com.bankingapp.util.QueryMapper;
@Repository("userDao")
@Transactional
public class UserDAO implements IUserDAO {
	private static Logger logger=Logger.getLogger(UserDAO.class);
	@PersistenceContext
	EntityManager em;
	@Override
	public Customer getCustomerDetails(User user) throws BankingException
	{
		TypedQuery<Customer> query=em.createQuery(QueryMapper.getCustomer,Customer.class);
		query.setParameter("accountId", user.getAccId());
		Customer cs=new Customer();
		try
		{
			cs=query.getSingleResult();
		}
		catch (Exception e)
		{
			throw new BankingException("Customer Not Found");
		}
		return cs;
	}
	@Override
	public User changePassword(User us,int uid) throws BankingException
	{
		try
		{
			User user=new User();
			TypedQuery<User> query=em.createQuery(QueryMapper.checkUser,User.class);
			query.setParameter("pwd",us.getPassword());
			query.setParameter("uid",uid);
			user=query.getSingleResult();
			user.setPassword(us.getTransPassword());
			em.merge(user);
			em.flush();
			em.getReference(User.class, uid);
			logger.info("Password has been changed successfully");
			return user;
		}
		catch (Exception e)
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
		} catch (Exception e) {
			throw new BankingException("Update Failed");
		}

	}

	@Override
	public void addCheckRequest(ServiceTracker st) throws BankingException
	{
		try
		{
			em.persist(st);
			em.flush();
		} catch (Exception e) {
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
		} catch (Exception e) {
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
		} catch (Exception e) {
			throw new BankingException("No open Request Found");
		}

	}

}
