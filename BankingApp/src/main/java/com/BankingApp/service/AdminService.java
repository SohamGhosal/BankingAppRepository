package com.BankingApp.service;

import com.BankingApp.dao.IAdminDAO;
import com.BankingApp.dto.BankAdmin;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.Transactions;
import com.BankingApp.exception.BankingException;
import com.BankingApp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("adminService")
@Transactional
public class AdminService implements IAdminService {
	@Autowired
	IAdminDAO adminDao;
	@Autowired
	AdminRepository adminRepository;
	@Override
	public boolean validateAdmin(BankAdmin bankAdmin) throws BankingException{
		return BCrypt.checkpw(bankAdmin.getAdminPassword(), adminRepository.findById(bankAdmin.getAdminId()).get().getAdminPassword());
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
