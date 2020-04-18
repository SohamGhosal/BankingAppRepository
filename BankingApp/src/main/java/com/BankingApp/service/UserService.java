package com.BankingApp.service;

import com.BankingApp.dao.IUserDAO;
import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.exception.BankingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service("userService")
@Transactional
public class UserService  implements IUserService{
	@Autowired
	IUserDAO userDao;
	@Override
	public Customer getCustomerDetails(BankUser user) throws BankingException
	{
		return userDao.getCustomerDetails(user);
	}
	@Override
	public BankUser changePassword(BankUser us) throws BankingException
	{
		return userDao.changePassword(us);
	}
	@Override
	public Customer updateDetails(Customer cus) throws BankingException
	{
		return userDao.updateDetails(cus);
	}
	@Override
	public ServiceTracker addCheckRequest(Integer accountId) throws BankingException
	{
		ServiceTracker serviceTracker=new ServiceTracker();
		serviceTracker.setAccId(accountId);
		serviceTracker.setServiceStatus("Pending");
		serviceTracker.setServiceDesc("Chqeue");
		serviceTracker.setServiceRaiseDate(LocalDate.now());
		return userDao.addCheckRequest(serviceTracker);
	}
	@Override
	public List<ServiceTracker> showServiceByAccID(int accid) throws BankingException
	{
		return userDao.showServiceByAccID(accid);
	}
	@Override
	public boolean checkPendingRequest(int accid) throws BankingException {
		return userDao.checkPendingRequest(accid);
	}
}
