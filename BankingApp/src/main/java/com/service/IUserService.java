package com.BankingApp.service;

import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.User;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IUserService {
	public Customer getCustomerDetails(User user) throws BankingException;
	public User changePassword(User us, int uid) throws BankingException;
	public Customer updateDetails(Customer cus) throws BankingException;
	public void addCheckRequest(ServiceTracker st) throws BankingException;
	public List<ServiceTracker> showServiceByAccID(int accid) throws BankingException;
	public void checkPendingRequest(int accid) throws BankingException;
}
