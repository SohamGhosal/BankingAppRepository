package com.BankingApp.service.impl;

import com.BankingApp.dto.AccountMaster;
import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.exception.BankingException;
import com.BankingApp.repository.AccountMasterRepository;
import com.BankingApp.repository.BankUserRepository;
import com.BankingApp.repository.CustomerRepository;
import com.BankingApp.repository.CustomerRequestsRepository;
import com.BankingApp.service.IRegistrationService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service("registrationService")
public class RegistrationService implements IRegistrationService {
	@Autowired
	private CustomerRequestsRepository customerRequestsRepository;
	@Autowired
	private AccountMasterRepository accountMasterRepository;
	@Autowired
	private BankUserRepository bankUserRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public void registerUser(CustomerRequests cr) throws BankingException {
		customerRequestsRepository.saveAndFlush(cr);
	}
	@Override
	public List<CustomerRequests> getCustReqList() throws BankingException {
		
		return customerRequestsRepository.findAll();
	}
	@Override
	public CustomerRequests getCustReq(String customerReqId) throws BankingException {

		return customerRequestsRepository.findById(customerReqId).get();
	}
	@Override
	@Transactional
	public void insertCustomer(String custReqId) throws BankingException {
		AccountMaster accountMaster = new AccountMaster();
		BankUser user = new BankUser();
		Customer customer= new Customer();
		CustomerRequests custReq = getCustReq(custReqId);
		accountMaster.setAccountId(RandomStringUtils.randomNumeric(6, 6));
		user.setAccId(accountMaster.getAccountId());
		user.setAnswer(custReq.getAnswer());
		user.setLockStatus("N");
		user.setPassword(BCrypt.hashpw(RandomStringUtils.randomAlphanumeric(6, 6),BCrypt.gensalt()));
		user.setSecretQues(custReq.getSecretQuest());
		user.setTransPassword(BCrypt.hashpw(RandomStringUtils.randomAlphanumeric(6, 6),BCrypt.gensalt()));
		user.setUserId(RandomStringUtils.randomNumeric(6, 6));
		accountMaster.setAccountType(custReq.getAccountType());
		accountMaster.setChequeStatus(custReq.getChequeStatus());
		accountMaster.setOpenDate(LocalDate.now());
		accountMaster.setReqId(custReq.getCustReqId());
		customer.setAccountId(user.getAccId());
		customer.setAddress(custReq.getAddress());
		customer.setCustName(custReq.getCustName());
		customer.setCustomerId(RandomStringUtils.randomNumeric(6, 6));
		customer.setEmail(custReq.getEmail());
		customer.setMobileNo(custReq.getMobileNo());
		customer.setPanNo(custReq.getPanNo());
		custReq.setStatus("Closed");
		accountMasterRepository.saveAndFlush(accountMaster);
		bankUserRepository.saveAndFlush(user);
		customerRepository.saveAndFlush(customer);
		customerRequestsRepository.saveAndFlush(custReq);
	}
}
