package com.bankingapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bankingapp.dto.BankAdmin;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.Transactions;
import com.bankingapp.exception.BankingException;
import com.bankingapp.util.QueryMapper;
@Repository("adminDao")
@Transactional
public class AdminDAO extends GenericBankDAO implements IAdminDAO{
	private static Logger logger=Logger.getLogger(AdminDAO.class);
	@PersistenceContext
	EntityManager em;
	@Override
	public BankAdmin validateAdmin(BankAdmin ba) throws BankingException{
		TypedQuery<BankAdmin> query=em.createQuery(QueryMapper.getAdmin,BankAdmin.class);
		query.setParameter("adminId", ba.getAdminId());
		query.setParameter("adminPassword", ba.getAdminPassword());
		try
		{
			ba=query.getSingleResult();
			logger.info("Admin is Validated!");
			return ba;
		}
		catch(Exception e)
		{
			throw new BankingException("Invalid Credentials");
		}

	}
	
	@Override
	public Customer getCust(int customerId) throws BankingException {
		try {
			Customer cust=em.getReference(Customer.class, customerId);
			return cust;
		} catch (Exception e) {
			throw new BankingException("No customer found!");
		}
	}
	
	@Override
	public List<Transactions> getAllLogs() throws BankingException {
		TypedQuery<Transactions> query=em.createQuery("FROM Transactions",Transactions.class);
		try {
			List<Transactions> transactionLogs=query.getResultList();
			if(transactionLogs.size()>0)
				return transactionLogs;
			else
				throw new BankingException("No transaction found");
		} catch (Exception e) {
			throw new BankingException("No transaction found");
		}
	}
	@Override
	public boolean confirmServiceByServiceID(int serviceId) throws BankingException {
		boolean res=false;
		try {
			ServiceTracker st=new ServiceTracker();
			st.setServiceId(serviceId);
			ServiceTracker	sts =showServiceByID(st);
			sts.setServiceStatus("Closed");
			em.merge(sts);
			res=true;
			return res;
		} catch (Exception e) {
			throw new BankingException("Not confirmed!");
		}
	}

	@Override
	public List<Customer> getCustInfo() throws BankingException {
		TypedQuery<Customer> query=em.createQuery("From Customer",Customer.class);
		try {
			List<Customer> cust=query.getResultList();
			return cust;
		} catch (Exception e) {
			throw new BankingException("No customer found!");
		}
	}

	@Override
	public boolean rejectServiceByServiceID(int serviceId) throws BankingException {
		boolean res=false;
		try {
			ServiceTracker st=new ServiceTracker();
			st.setServiceId(serviceId);
			ServiceTracker	sts =showServiceByID(st);
			sts.setServiceStatus("Rejected");
			em.merge(sts);
			res=true;
			return res;
		} catch (Exception e) {
			throw new BankingException("Not Rejected!");
		}
	}
	@Override
	public List<ServiceTracker> getUserReq() throws BankingException {
		TypedQuery<ServiceTracker> query=em.createQuery
				(QueryMapper.getOpenService,ServiceTracker.class);
		query.setParameter("status","Open");
		try {
			List<ServiceTracker> list=query.getResultList();
			return list;
		} catch (Exception e) {
			throw new BankingException("No Service opened");
		}
	}
}
