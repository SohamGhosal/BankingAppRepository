package com.BankingApp.service.impl;

import com.BankingApp.dto.BankAdmin;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.Transactions;
import com.BankingApp.exception.BankingException;
import com.BankingApp.repository.AdminRepository;
import com.BankingApp.repository.CustomerRepository;
import com.BankingApp.repository.ServiceTrackerRepository;
import com.BankingApp.repository.TransactionsRepository;
import com.BankingApp.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminService implements IAdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private TransactionsRepository transactionsRepository;
	@Autowired
	private ServiceTrackerRepository serviceTrackerRepository;
	@Override
	public boolean validateAdmin(BankAdmin bankAdmin) throws BankingException{
		System.out.println(BCrypt.hashpw("test",BCrypt.gensalt()));
		return BCrypt.checkpw(bankAdmin.getAdminPassword(), adminRepository.findById(bankAdmin.getAdminId()).get().getAdminPassword());
	}
	@Override
	public Customer getCust(String customerId) throws BankingException {
		return customerRepository.findById(customerId).get();
	}
	@Override
	public List<Transactions> getAllLogs() throws BankingException {
		
		return transactionsRepository.findAll();
	}
	@Override
	public List<Customer> getCustInfo() throws BankingException {
		
		return customerRepository.findAll();
	}
	@Override
	public void rejectServiceByServiceID(String serviceId) throws BankingException {
		serviceTrackerRepository.delete(serviceTrackerRepository.findById(serviceId).get());
	}
	@Override
	public List<ServiceTracker> getUserReq() throws BankingException {
		
		return serviceTrackerRepository.findAll();
	}

	@Override
	public void registerAdmin(BankAdmin bankAdmin) throws BankingException {
		bankAdmin.setAdminPassword(BCrypt.hashpw(bankAdmin.getAdminPassword(),BCrypt.gensalt()));
		adminRepository.saveAndFlush(bankAdmin);
	}
}
