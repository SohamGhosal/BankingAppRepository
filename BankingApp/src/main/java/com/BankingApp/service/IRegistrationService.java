package com.BankingApp.service;

import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IRegistrationService {
	public boolean registerUser(CustomerRequests cr) throws BankingException;
	public List<CustomerRequests>getCustReqList() throws BankingException;
	public boolean insertCustomer(Integer custReqId) throws BankingException;
	public CustomerRequests getCustReq(Integer customerReqId) throws BankingException;
}
