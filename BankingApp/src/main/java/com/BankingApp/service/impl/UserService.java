package com.BankingApp.service.impl;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.exception.BankingException;
import com.BankingApp.repository.BankUserRepository;
import com.BankingApp.repository.CustomerRepository;
import com.BankingApp.repository.ServiceTrackerRepository;
import com.BankingApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UserService  implements IUserService {
	@Autowired
	private BankUserRepository bankUserRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private GenericBankService genericBankService;
	@Autowired
	private ServiceTrackerRepository serviceTrackerRepository;
	@Override
	public Customer getCustomerDetails(BankUser user) throws BankingException
	{
		return customerRepository.findByAccountId(user.getAccId());
	}
	@Override
	public BankUser changePassword(BankUser user) throws BankingException
	{
		String password= BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
		if(genericBankService.loginUser(user))
		{
			user.setPassword(password);
			bankUserRepository.saveAndFlush(user);
		}
		else
		{
			throw new BankingException("Failed");
		}
		return genericBankService.getUserDetails(user);
	}
	@Override
	public void updateDetails(Customer cus) throws BankingException
	{
		customerRepository.saveAndFlush(cus);
	}
	@Override
	public void addCheckRequest(String accountId) throws BankingException
	{
		ServiceTracker serviceTracker=new ServiceTracker();
		serviceTracker.setAccountId(accountId);
		serviceTracker.setServiceStatus("Pending");
		serviceTracker.setServiceDesc("Chqeue");
		serviceTracker.setServiceRaiseDate(LocalDate.now());
		serviceTrackerRepository.saveAndFlush(serviceTracker);
	}
	@Override
	public List<ServiceTracker> showServiceByAccID(String accid) throws BankingException
	{
		return serviceTrackerRepository.findByAccountId(accid);
	}
	@Override
	public boolean checkPendingRequest(String accid) throws BankingException {
		return serviceTrackerRepository
				.findByAccountId(accid)
				.stream()
				.filter(k->k.getServiceStatus().equalsIgnoreCase("Pending"))
				.collect(Collectors.toList())
				.isEmpty();
	}
}
