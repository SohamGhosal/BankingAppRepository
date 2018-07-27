package com.bankingapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bankingapp.dao.IRegistrationDAO;
import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
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
