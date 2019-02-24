package com.BankingApp.service;

import com.BankingApp.dto.BankAdmin;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.Transactions;
import com.BankingApp.exception.BankingException;

import java.util.List;

public interface IAdminService {
	public BankAdmin validateAdmin(BankAdmin ba) throws BankingException;
	public Customer getCust(int customerId) throws BankingException;
	public List<Transactions> getAllLogs() throws BankingException;
	public boolean confirmServiceByServiceID(int serviceId) throws BankingException;
	public List<Customer> getCustInfo() throws BankingException;
	public boolean rejectServiceByServiceID(int serviceId) throws BankingException;
	public List<ServiceTracker>getUserReq() throws BankingException;
}
