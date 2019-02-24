package com.BankingApp.service;

import com.BankingApp.dao.IUserDAO;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.User;
import com.BankingApp.exception.BankingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
