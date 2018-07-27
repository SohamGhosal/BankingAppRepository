package com.bankingapp.service;

import java.util.List;

import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;

public interface IRegistrationService {
	public boolean registerUser(CustomerRequests cr) throws BankingException;
	public List<CustomerRequests>getCustReqList() throws BankingException;
	public boolean insertCustomer(AccountMaster acc,User user,Customer cust,CustomerRequests custReq) throws BankingException;
	public CustomerRequests getCustReq(Integer customerReqId) throws BankingException;
}
