package com.BankingApp.service;

import com.BankingApp.dao.IRegistrationDAO;
import com.BankingApp.dto.AccountMaster;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.dto.User;
import com.BankingApp.exception.BankingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
	public boolean insertCustomer(AccountMaster acc,User user,Customer cust,CustomerRequests custReq) throws BankingException {
		
		return registrationDao.insertCustomer(acc, user, cust, custReq);
	}
}
