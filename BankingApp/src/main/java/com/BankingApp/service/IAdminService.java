package com.BankingApp.service;

import com.BankingApp.dto.BankAdmin;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.Transactions;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IAdminService {
	public boolean validateAdmin(BankAdmin ba) throws BankingException;
	public Customer getCust(String customerId) throws BankingException;
	public List<Transactions> getAllLogs() throws BankingException;
	public List<Customer> getCustInfo() throws BankingException;
	public void rejectServiceByServiceID(String serviceId) throws BankingException;
	public List<ServiceTracker>getUserReq() throws BankingException;
}
