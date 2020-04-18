package com.BankingApp.dao;

import com.BankingApp.dto.AccountMaster;
import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IRegistrationDAO {
	public boolean registerUser(CustomerRequests cr) throws BankingException;
	public List<CustomerRequests>getCustReqList() throws BankingException;
	public boolean insertCustomer(AccountMaster acc, BankUser user, Customer cust, CustomerRequests custReq) throws BankingException;
	public CustomerRequests getCustReq(Integer customerReqId) throws BankingException;
}
