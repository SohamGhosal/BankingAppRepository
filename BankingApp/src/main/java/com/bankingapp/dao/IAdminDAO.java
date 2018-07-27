package com.bankingapp.dao;

import java.util.List;

import com.bankingapp.dto.BankAdmin;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.Transactions;
import com.bankingapp.exception.BankingException;

public interface IAdminDAO {
	public BankAdmin validateAdmin(BankAdmin ba) throws BankingException;
	public Customer getCust(int customerId) throws BankingException;
	public List<Transactions> getAllLogs() throws BankingException;
	public boolean confirmServiceByServiceID(int serviceId) throws BankingException;
	public List<Customer> getCustInfo() throws BankingException;
	public boolean rejectServiceByServiceID(int serviceId) throws BankingException;
	public List<ServiceTracker>getUserReq() throws BankingException;
}
