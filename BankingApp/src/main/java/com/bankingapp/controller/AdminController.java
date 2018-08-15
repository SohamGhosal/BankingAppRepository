package com.bankingapp.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bankingapp.dto.BankAdmin;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.ServiceTracker;
import com.bankingapp.dto.Transactions;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
import com.bankingapp.service.AdminService;
import com.bankingapp.service.IAdminService;

@Controller("/BankAdmin")
public class AdminController extends BankController{
	@Autowired
	IAdminService adminService=new AdminService();
	private static Logger logger=Logger.getLogger(AdminController.class);
	@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
	public ModelAndView loginAdmin(HttpServletRequest req,@ModelAttribute("bankAdmin")BankAdmin ba)
	{
		request=req;
		session=req.getSession();
		try {
			BankAdmin baD = adminService.validateAdmin(ba);
			session.setAttribute("ba",baD);
			logger.info("Login Successful");
			return new ModelAndView("AdminHome");
		} catch (BankingException e) {
			return new ModelAndView("index","msg","Invalid Info");
		}
	}

	@RequestMapping(value="/CnfUsrReq",method=RequestMethod.GET)
	public ModelAndView cnfUserReq(HttpServletRequest req)
	{
		List<ServiceTracker> UserReq;
		try {
			UserReq = adminService.getUserReq();
			return new ModelAndView("UserReq","UserReq",UserReq);
		} catch (BankingException e) {
			return new ModelAndView("AdminHome","msg","Error Occured");
		}

	}
	
	@RequestMapping(value="/ConfirmReq",method=RequestMethod.POST)
	public ModelAndView cnfReq(HttpServletRequest req,@RequestParam("serviceId")Integer serviceId)
	{
		try {
			boolean res=adminService.confirmServiceByServiceID(serviceId);
			if(res==true)
			{
				List<ServiceTracker> UserReq=adminService.getUserReq();
				return new ModelAndView("UserReq","msg","Confirmed");
			}
			else
				return new ModelAndView("UserReq","msg","Error");
		} catch (BankingException e) {
			return new ModelAndView("AdminHome","msg","Error");
		}
	}
	@RequestMapping(value="RejectRequest",method=RequestMethod.GET)
	public ModelAndView delReq(HttpServletRequest req)
	{
		try {
			int serviceId=(int) session.getAttribute("serviceId");
			boolean res=adminService.rejectServiceByServiceID(serviceId);
			if(res==true)
			{
				List<ServiceTracker> UserReq=adminService.getUserReq();
				return new ModelAndView("UserReq","msg","Rejected");
			}
			else
				return new ModelAndView("UserReq","msg","Error");
		} catch (BankingException e) {
			return new ModelAndView("AdminHome","msg","Error");
		}
	}
	@RequestMapping(value="/ViewAllCustomers",method=RequestMethod.GET)
	public ModelAndView viewCust(HttpServletRequest req)
	{
		try {
			List<Customer>custInfo=adminService.getCustInfo();
			return new ModelAndView("CustInfo","custInfo",custInfo);
		} catch (BankingException e) {
			return new ModelAndView("AdminHome","msg","No Customer Found!");
		}

	}
	@RequestMapping(value="/ViewCustomer",method=RequestMethod.POST)
	public ModelAndView viewCust(HttpServletRequest req,@RequestParam("customerId")int customerId)
	{
		try {
			Customer custInfo=adminService.getCust(customerId);
			List<Customer>custInfos=new ArrayList<Customer>();
			custInfos.add(custInfo);
			return new ModelAndView("CustInfo","custInfo",custInfos);
		} catch (BankingException e) {
			return new ModelAndView("AdminHome","msg","No Customer Found!");
		}

	}
	@RequestMapping(value="/getLog",method=RequestMethod.POST)
	public ModelAndView getLog(HttpServletRequest req,@RequestParam("accountId")int accountId)
	{
		try {
			List<Transactions>getLog=bankService.getStatements(accountId);
			return new ModelAndView("AdminTransactionLogs","transaction",getLog);
		} catch (BankingException e) {
			return new ModelAndView("AdminHome","msg","No Transactions Found");
		}

	}
	@RequestMapping(value="/getAllLogs",method=RequestMethod.GET)
	public ModelAndView getAllLogs(HttpServletRequest req)
	{
		try {
			List<Transactions>getLog=adminService.getAllLogs();
			session.setAttribute("tLog", "detailed");
			return new ModelAndView("AdminTransactionLogs","transaction",getLog);
		} catch (BankingException e) {
			return new ModelAndView("AdminHome","msg","No Transactions Found");
		}
	}
	@RequestMapping(value="/adminhome",method=RequestMethod.GET)
	public ModelAndView adminHome(@ModelAttribute("accountRecover") User us)
	{	
		return new ModelAndView("AdminHome");
	}
	@RequestMapping(value="/adminLogout",method=RequestMethod.GET)
	public ModelAndView logout()
	{	
		session.invalidate();
		return new ModelAndView("index");
	}
}
