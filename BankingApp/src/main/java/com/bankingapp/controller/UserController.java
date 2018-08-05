package com.bankingapp.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.BankAdmin;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.CustomerRequests;
import com.bankingapp.dto.PayeeTable;
import com.bankingapp.dto.SecurityQuest;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.Transactions;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
import com.bankingapp.service.IUserService;
import com.bankingapp.service.UserService;

@Controller("/LoginUser")
public class UserController extends BankController{
	private static Logger logger=Logger.getLogger(UserController.class);
	@Autowired
	IUserService userService=new UserService();
	@RequestMapping(value="/loginpage",method=RequestMethod.GET)
	public ModelAndView loginUser(HttpServletRequest req,@ModelAttribute("accountholder")User us,@ModelAttribute("customer")Customer 
cus,@ModelAttribute("customerRequest")CustomerRequests cr,@ModelAttribute("bankAdmin")BankAdmin ba)
	{
		List<SecurityQuest> secretQuest;
		try {
			secretQuest = bankService.getQuestionList();
			logger.info("Login Page is loaded successfully");
			return new ModelAndView("Login","secretQuest", secretQuest);
		} catch (BankingException e) {
			return new ModelAndView("Login","error","Question Not found");
		}

	}

	@RequestMapping(value="/loginuser",method=RequestMethod.POST)
	public ModelAndView loginUserDataBase(HttpServletRequest req,@ModelAttribute("customer")Customer cus,@ModelAttribute("accountholder") @Valid User us,BindingResult result) 
throws BankingException
	{
		request=null;
		if(result.hasErrors())
		{
			return new ModelAndView("index","msg","");
		}
		else
		{
			request=req;
			session=req.getSession();
			User user=new User();
			try
			{
				user=bankService.getUserDetails(us);
				cus=userService.getCustomerDetails(user);
				AccountMaster acc=bankService.getAccountDetails(user.getAccId());
				session.setAttribute("user",user);
				session.setAttribute("cus",cus);
				session.setAttribute("acc", acc);
				session.setAttribute("tLog", null);
				return new ModelAndView("Welcome");
			}
			catch(BankingException e)
			{
				return new ModelAndView("index","msg","Invalid Credentials");
			}
		}
	}

	@RequestMapping(value="/ChangePwd",method=RequestMethod.POST)
	public ModelAndView changePassword(@ModelAttribute("accountholder")User us,@ModelAttribute("customer")Customer cust)
	{
		String Msg=null;
		User sessionUser=(User) session.getAttribute("user");
		
if(us.getPassword().equals(sessionUser.getPassword())&&!(us.getTransPassword().equals(sessionUser.getTransPassword())||us.getTransPassword().equals(sessionUser.getPassword())
))
		{
			try
			{
				Msg="Password has been changed Successfully";
				sessionUser = userService.changePassword(us,sessionUser.getUserId());
				session.removeAttribute("user");
				session.setAttribute("user", sessionUser);
				Msg="Password has been changed Successfully";
				logger.info(Msg);
				return new ModelAndView("Welcome","msg",Msg);
			}
			catch (BankingException e)
			{
				Msg="Password change is unsuccessful";
				return new ModelAndView("Welcome","msg",Msg);
			}
		}
		else if(!(us.getPassword().equals(sessionUser.getPassword())))
		{
			Msg="Wrong Current password provided";
			return new ModelAndView("Welcome","msg",Msg);
		}

		else if(!(us.getTransPassword().equals(sessionUser.getPassword())))
		{
			Msg="Old password and new password should not be same";
			return new ModelAndView("Welcome","msg",Msg);
		}
		else if(!(us.getTransPassword().equals(sessionUser.getTransPassword())))
		{
			Msg="Password and Transaction Password cannot be same";
			return new ModelAndView("Welcome","msg",Msg);
		}
		else
		{
			return null;
		}
	}

	@RequestMapping(value="/Update",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("customer")Customer customer,Model model,@ModelAttribute("accountholder")User user) 
	{
		Customer customers=(Customer)session.getAttribute("cus");
		customers.setAddress(customer.getAddress());
		customers.setMobileNo(customer.getMobileNo());
		String pattern="[7-9]{1}[0-9]{9}";
		boolean res=Pattern.matches(pattern,customer.getMobileNo());
		if(res==true)
		{
			Customer cus =new Customer();
			try {
				cus=userService.updateDetails(customers);
				session.removeAttribute("cus");
				session.setAttribute("cus", cus);
				return new ModelAndView("Welcome","customer",cus);
			} catch (BankingException e) {
				return new ModelAndView("Welcome","msg","Error Occured");
			}
		}
		else
		{
			return new ModelAndView("Welcome","msg","Invalid Mobile No");
		}
	}

	@RequestMapping(value="backToHome",method=RequestMethod.GET)
	public String backToHome(@ModelAttribute("customer")Customer customer,@ModelAttribute("accountholder")User user)
	{
		return "Welcome";

	}

	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute("accountRecover") User us)
	{	us=null;
	session.invalidate();
	return new ModelAndView("index");
	}

	@RequestMapping(value="addrequest",method=RequestMethod.GET)
	public ModelAndView addRequest(@ModelAttribute("bank")ServiceTracker st,@ModelAttribute("customer")Customer customer,@ModelAttribute("accountholder")User us)
	{
		int accid=((AccountMaster)session.getAttribute("acc")).getAccountId();
		st.setAccId(accid);
		st.setServiceDesc("Request For CheckBook");
		LocalDate todays_date=LocalDate.now();
		st.setServiceRaiseDate(Date.valueOf(todays_date));
		st.setServiceStatus("Open");
		try {
			userService.checkPendingRequest(accid);
			return new ModelAndView("Welcome","msg","You already have booking request!");
		}
		catch (BankingException e) {
			try
			{
				userService.addCheckRequest(st);
				return new ModelAndView("Welcome","msg","Checkbook Request has been submitted");
			}
			catch(BankingException e1)
			{
				return new ModelAndView("Welcome","msg","Request Failed");
			}

		}
			
	}

	@RequestMapping(value="ByServiceid",method=RequestMethod.POST)
	public ModelAndView getById(HttpServletRequest request,@RequestParam("serviceId")Integer serviceId,@ModelAttribute("customer")Customer 
customer,@ModelAttribute("accountholder")User us)
	{
		ServiceTracker st=new ServiceTracker();
		st.setServiceId(serviceId);
		try {
			ServiceTracker sts=bankService.showServiceByID(st);
			return new ModelAndView("Show","ser",sts);
		} catch (BankingException e) {
			return new ModelAndView("Welcome","msg","No Service Request Available");
		}
	}

	@RequestMapping(value="displayacc",method=RequestMethod.GET)
	public ModelAndView getByAccId(@ModelAttribute("bank")ServiceTracker st,@ModelAttribute("trans") PayeeTable trans,@ModelAttribute("customer")Customer 
customer,@ModelAttribute("accountholder")User us)
	{
		int accid=((AccountMaster)session.getAttribute("acc")).getAccountId();
		List<ServiceTracker> list;
		try {
			list = userService.showServiceByAccID(accid);
			return new ModelAndView("Display","acclist",list);
		} catch (BankingException e) {
			return new ModelAndView("Welcome","msg","No Request found");
		}
	}
	@RequestMapping(value="/MiniStatement",method=RequestMethod.GET)
	public ModelAndView getFundTransfermini(@ModelAttribute("customer")Customer customer,@ModelAttribute("accountholder")User us)
	{
		int accid=((AccountMaster)session.getAttribute("acc")).getAccountId();
		List<Transactions> transaction;
		try {
			transaction=bankService.getStatements(accid);
			if(session.getAttribute("tLog")!=null)
			{
				session.removeAttribute("tLog");
			}
			session.setAttribute("tLog", "mini");
			return new ModelAndView("UserTransactionLogs","transaction",transaction);
		} catch (BankingException e) {
			return new ModelAndView("Welcome","msg","Tranactions Not found");
		}


	}

	@RequestMapping(value="/DetailedStatement",method=RequestMethod.GET)
	public ModelAndView getFundTransferdetailed(@ModelAttribute("customer")Customer customer,@ModelAttribute("accountholder")User us)
	{
		int accid=((AccountMaster)session.getAttribute("acc")).getAccountId();
		List<Transactions> transaction;
		try {
			transaction=bankService.getStatements(accid);
			if(session.getAttribute("tLog")!=null)
			{
				session.removeAttribute("tLog");
			}
			session.setAttribute("tLog", "detailed");
			return new ModelAndView("UserTransactionLogs","transaction",transaction);
		} catch (BankingException e) {
			return new ModelAndView("Welcome","msg","Tranactions Not found");
		}
	}
}
