package com.BankingApp.service;

import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IRegistrationService {
	public void registerUser(CustomerRequests cr) throws BankingException;
	public List<CustomerRequests>getCustReqList() throws BankingException;
	public void insertCustomer(String custReqId) throws BankingException;
	public CustomerRequests getCustReq(String customerReqId) throws BankingException;
}
