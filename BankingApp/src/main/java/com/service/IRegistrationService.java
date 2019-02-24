package com.BankingApp.service;

import com.BankingApp.dto.AccountMaster;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.dto.User;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IRegistrationService {
	public boolean registerUser(CustomerRequests cr) throws BankingException;
	public List<CustomerRequests>getCustReqList() throws BankingException;
	public boolean insertCustomer(AccountMaster acc, User user, Customer cust, CustomerRequests custReq) throws BankingException;
	public CustomerRequests getCustReq(Integer customerReqId) throws BankingException;
}
