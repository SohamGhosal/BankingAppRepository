package com.bankingapp.controller;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.SecurityQuest;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
import com.bankingapp.service.IRegistrationService;
import com.bankingapp.service.RegistrationService;

@Controller("/Register")
public class RegistrationController extends BankController{
	private static Logger logger=Logger.getLogger(RegistrationController.class);
	@Autowired
	IRegistrationService registrationService=new RegistrationService();
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("customerRequest")CustomerRequests custReq,@RequestParam("fname")String fName,@RequestParam("lname")String lName)
	{
		custReq.setCustName(fName+" "+lName);
		custReq.setStatus("Open");
		try {
			registrationService.registerUser(custReq);
			return new ModelAndView("index","msg","Registration is successful. Pleasd wait for few days for activation");
		} catch (BankingException e) {
			return new ModelAndView("index","msg","Registration is unsuccessful. Pleasd try again later");
		}


	}

	@RequestMapping(value="/Register",method=RequestMethod.GET)
	public ModelAndView registerUser(@ModelAttribute("customerRequest")CustomerRequests custReq,HttpServletRequest req)
	{
		List<SecurityQuest> secretQuest;
		try {
			secretQuest = bankService.getQuestionList();
			return new ModelAndView("Register","secretQuest", secretQuest);
		} catch (BankingException e) {
			return new ModelAndView("AdminHome","msg","No Data Found");
		}

	}

	@RequestMapping(value="/CnfUser",method=RequestMethod.GET)
	public ModelAndView cnfUser(HttpServletRequest req)
	{
		List<CustomerRequests> customerReq;
		try {
			customerReq = registrationService.getCustReqList();
			return new ModelAndView("ViewCustReq","custReq",customerReq);
		} catch (BankingException e) {
			return new ModelAndView("AdminHome","msg","NO Records Found");
		}

	}

	@RequestMapping(value="/ConfirmAcc",method=RequestMethod.POST)
	public ModelAndView cnfAcc(HttpServletRequest req,@RequestParam("custReqId")Integer custReqId)
	{
		AccountMaster acc=new AccountMaster();
		User us=new User();
		Customer cust=new Customer();
		boolean res;
		try {
			CustomerRequests custReq=registrationService.getCustReq(custReqId);
			acc.setAccountId(Integer.parseInt(RandomStringUtils.randomNumeric(6,6)));
			us.setAccId(acc.getAccountId());
			us.setAnswer(custReq.getAnswer());
			us.setLockStatus("N");
			us.setPassword(RandomStringUtils.randomAlphanumeric(6,6)+"#");
			us.setSecretQues(custReq.getSecretQuest());
			us.setTransPassword(RandomStringUtils.randomAlphanumeric(6,6)+"#");
			us.setUserId(Integer.parseInt(RandomStringUtils.randomNumeric(6,6)));
			acc.setAccountBal(custReq.getAccountBal());
			acc.setAccountType(custReq.getAccountType());
			acc.setChequeStatus(custReq.getChequeStatus());
			acc.setOpenDate(LocalDate.now());
			acc.setReqId(custReq.getCustReqId());
			cust.setAccountId(us.getAccId());
			cust.setAddress(custReq.getAddress());
			cust.setCustName(custReq.getCustName());
			cust.setCustomerId(Integer.parseInt(RandomStringUtils.randomNumeric(6,6)));
			cust.setEmail(custReq.getEmail());
			cust.setMobileNo(custReq.getMobileNo());
			cust.setPanNo(custReq.getPanNo());
			custReq.setStatus("Closed");
			res = registrationService.insertCustomer(acc, us, cust,custReq);
			if(res)
			{
				logger.info("Account Created Successfully");
				return new ModelAndView("ViewCustReq","msg","Account Created Successfully");
			}
			else
			{
				return new ModelAndView("ViewCustReq","msg","Error Occured");
			}
		} catch (BankingException e) {
			return new ModelAndView("ViewCustReq","msg","Error Occured");
		}

	}


}
