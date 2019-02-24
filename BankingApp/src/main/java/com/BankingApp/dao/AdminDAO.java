package com.BankingApp.dao;

import com.BankingApp.dto.BankAdmin;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.Transactions;
import com.BankingApp.exception.BankingException;
import com.BankingApp.util.QueryMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("adminDao")
@Transactional
public class AdminDAO extends GenericBankDAO implements IAdminDAO{
	private static Logger logger= LogManager.getLogger(AdminDAO.class);
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
		catch(PersistenceException e)
		{
			throw new BankingException("Invalid Credentials");
		}

	}
	
	@Override
	public Customer getCust(int customerId) throws BankingException {
		try {
			Customer cust=em.getReference(Customer.class, customerId);
			return cust;
		} catch (PersistenceException e) {
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
		} catch(PersistenceException e){
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
		} catch(PersistenceException e){
			throw new BankingException("Not confirmed!");
		}
	}

	@Override
	public List<Customer> getCustInfo() throws BankingException {
		TypedQuery<Customer> query=em.createQuery("From Customer",Customer.class);
		try {
			List<Customer> cust=query.getResultList();
			return cust;
		} catch(PersistenceException e){
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
		} catch(PersistenceException e){
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
		} catch(PersistenceException e){
			throw new BankingException("No Service opened");
		}
	}
}
