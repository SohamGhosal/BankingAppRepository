package com.BankingApp.service;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IUserService {
	public Customer getCustomerDetails(BankUser user) throws BankingException;
	public BankUser changePassword(BankUser us) throws BankingException;
	public void updateDetails(Customer cus) throws BankingException;
	public void addCheckRequest(String accountId) throws BankingException;
	public List<ServiceTracker> showServiceByAccID(String accid) throws BankingException;
	public boolean checkPendingRequest(String accid) throws BankingException;
}
