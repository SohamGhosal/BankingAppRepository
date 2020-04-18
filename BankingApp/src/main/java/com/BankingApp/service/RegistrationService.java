package com.BankingApp.service;

import com.BankingApp.dao.IRegistrationDAO;
import com.BankingApp.dto.AccountMaster;
import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.exception.BankingException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service("registrationService")
@Transactional
public class RegistrationService implements IRegistrationService {
	@Autowired
	IRegistrationDAO registrationDao;
	@Override
	public boolean registerUser(CustomerRequests cr) throws BankingException {
		
		return registrationDao.registerUser(cr);
	}
	@Override
	public List<CustomerRequests> getCustReqList() throws BankingException {
		
		return registrationDao.getCustReqList();
	}
	@Override
	public CustomerRequests getCustReq(Integer customerReqId) throws BankingException {
		
		return registrationDao.getCustReq(customerReqId);
	}
	@Override
	public boolean insertCustomer(Integer custReqId) throws BankingException {
		AccountMaster acc = new AccountMaster();
		BankUser user = new BankUser();
		Customer customer= new Customer();
		CustomerRequests custReq = getCustReq(custReqId);
		acc.setAccountId(Integer.parseInt(RandomStringUtils.randomNumeric(6, 6)));
		user.setAccId(acc.getAccountId());
		user.setAnswer(custReq.getAnswer());
		user.setLockStatus("N");
		user.setPassword(BCrypt.hashpw(RandomStringUtils.randomAlphanumeric(6, 6),BCrypt.gensalt()));
		user.setSecretQues(custReq.getSecretQuest());
		user.setTransPassword(BCrypt.hashpw(RandomStringUtils.randomAlphanumeric(6, 6),BCrypt.gensalt()));
		user.setUserId(Integer.parseInt(RandomStringUtils.randomNumeric(6, 6)));
		acc.setAccountType(custReq.getAccountType());
		acc.setChequeStatus(custReq.getChequeStatus());
		acc.setOpenDate(LocalDate.now());
		acc.setReqId(custReq.getCustReqId());
		customer.setAccountId(user.getAccId());
		customer.setAddress(custReq.getAddress());
		customer.setCustName(custReq.getCustName());
		customer.setCustomerId(Integer.parseInt(RandomStringUtils.randomNumeric(6, 6)));
		customer.setEmail(custReq.getEmail());
		customer.setMobileNo(custReq.getMobileNo());
		customer.setPanNo(custReq.getPanNo());
		custReq.setStatus("Closed");
		return registrationDao.insertCustomer(acc, user, customer, custReq);
	}
}
