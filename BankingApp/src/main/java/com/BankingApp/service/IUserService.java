package com.BankingApp.service;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IUserService {
	public Customer getCustomerDetails(BankUser user) throws BankingException;
	public BankUser changePassword(BankUser us) throws BankingException;
	public Customer updateDetails(Customer cus) throws BankingException;
	public ServiceTracker addCheckRequest(Integer accountId) throws BankingException;
	public List<ServiceTracker> showServiceByAccID(int accid) throws BankingException;
	public boolean checkPendingRequest(int accid) throws BankingException;
}
