package com.bankingapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapp.dao.IUserDAO;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
@Service("userService")
@Transactional
public class UserService  implements IUserService{
	@Autowired
	IUserDAO userDao;
	@Override
	public Customer getCustomerDetails(User user) throws BankingException
	{
		return userDao.getCustomerDetails(user);
	}
	@Override
	public User changePassword(User us,int uid) throws BankingException
	{
		return userDao.changePassword(us,uid);
	}
	@Override
	public Customer updateDetails(Customer cus) throws BankingException
	{
		return userDao.updateDetails(cus);
	}
	@Override
	public void addCheckRequest(ServiceTracker st) throws BankingException
	{
		userDao.addCheckRequest(st);
	}
	@Override
	public List<ServiceTracker> showServiceByAccID(int accid) throws BankingException
	{
		return userDao.showServiceByAccID(accid);
	}
	@Override
	public void checkPendingRequest(int accid) throws BankingException {
		userDao.checkPendingRequest(accid);
	}
}
