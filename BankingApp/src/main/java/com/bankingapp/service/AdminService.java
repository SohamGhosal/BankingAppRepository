package com.bankingapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapp.dao.IAdminDAO;
import com.bankingapp.dto.BankAdmin;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.Transactions;
import com.bankingapp.exception.BankingException;
@Service("adminService")
@Transactional
public class AdminService implements IAdminService {
	@Autowired
	IAdminDAO adminDao;
	@Override
	public BankAdmin validateAdmin(BankAdmin ba) throws BankingException{
		return adminDao.validateAdmin(ba);
	}
	@Override
	public Customer getCust(int customerId) throws BankingException {
		
		return adminDao.getCust(customerId);
	}
	@Override
	public List<Transactions> getAllLogs() throws BankingException {
		
		return adminDao.getAllLogs();
	}
	@Override
	public boolean confirmServiceByServiceID(int serviceId) throws BankingException {
		
		return adminDao.confirmServiceByServiceID(serviceId);
	}
	@Override
	public List<Customer> getCustInfo() throws BankingException {
		
		return adminDao.getCustInfo();
	}
	@Override
	public boolean rejectServiceByServiceID(int serviceId) throws BankingException {
		return adminDao.rejectServiceByServiceID(serviceId);
	}
	@Override
	public List<ServiceTracker> getUserReq() throws BankingException {
		
		return adminDao.getUserReq();
	}
}
