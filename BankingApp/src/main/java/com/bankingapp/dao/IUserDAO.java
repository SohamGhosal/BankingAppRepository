package com.bankingapp.dao;

import java.util.List;

import com.bankingapp.dto.Customer;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;

public interface IUserDAO {
	public Customer getCustomerDetails(User user) throws BankingException;
	public User changePassword(User us,int uid) throws BankingException;
	public Customer updateDetails(Customer cus) throws BankingException;
	public void addCheckRequest(ServiceTracker st) throws BankingException;
	public List<ServiceTracker> showServiceByAccID(int accid) throws BankingException;
	public void checkPendingRequest(int accid) throws BankingException;
}
