package com.bankingapp.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
import com.bankingapp.dto.ServiceTracker;
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
			String uuid = UUID.randomUUID().toString();
			String upass=uuid.substring(0, 4)+"#";
			String uuid1 = UUID.randomUUID().toString();
			String tpass=uuid1.substring(0, 4)+"#";
			acc.setAccountId(generatePin());
			us.setAccId(acc.getAccountId());
			us.setAns(custReq.getAns());
			us.setLockStatus("N");
			us.setPassword(upass);
			us.setSecretQues(custReq.getSecretQuest());
			us.setTransPassword(tpass);
			us.setUserId(generatePin());
			acc.setAccountBal(custReq.getAccountBal());
			acc.setAccountType(custReq.getAccountType());
			acc.setChequeStatus(custReq.getChequeStatus());
			acc.setOpenDate(Date.valueOf(LocalDate.now()));
			acc.setReqId(custReq.getCustReqId());
			cust.setAccountId(us.getAccId());
			cust.setAddress(custReq.getAddress());
			cust.setCustName(custReq.getCustName());
			cust.setCustomerId(generatePin());
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
