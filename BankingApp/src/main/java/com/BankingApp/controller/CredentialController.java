package com.BankingApp.controller;

import com.BankingApp.dto.User;
import com.BankingApp.exception.BankingException;
import com.BankingApp.service.CredentialService;
import com.BankingApp.service.ICredentialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller("/ControlCredential")
@Slf4j
public class CredentialController extends BankController{
	@Autowired
	ICredentialService credentialService=new CredentialService();
	@RequestMapping(value="/ForgotAccount",method=RequestMethod.POST)
	public ModelAndView recoverAccount(@ModelAttribute("accountholder") @Valid User us,BindingResult result,HttpServletRequest req)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("RecoverUser");
		}
		else
		{
			User user;
			try
			{
				user = bankService.getUserDetails(us);
				request=req;
				session=request.getSession();
				session.setAttribute("userRecovery", user);
				return new ModelAndView("RecoverAccount","user",user);
			}
			catch (BankingException e)
			{
				return new ModelAndView("RecoverUser","error","Invalid User ID");
			}
		}

	}
	
	@RequestMapping(value="/ForgotPass",method=RequestMethod.POST)
	public ModelAndView getPass(@ModelAttribute("accountRecover") @Valid User us,BindingResult result) throws BankingException
	{
		User user=(User)session.getAttribute("userRecovery");
		if(result.hasErrors())
		{
			return new ModelAndView("RecoverAccount");
		}
		else
		{
			if(us.getAnswer().equals(user.getAnswer()))
			{
				String password;
				try {
					password = credentialService.generateNewPassword(user);
					log.info("New Password Generated!");
					session.invalidate();
					return new ModelAndView("index","pwd",password);
				} catch (BankingException e) {

					return new ModelAndView("index","pwd","Password Not Changed!");
				}
			}
			else
			{
				try {
					credentialService.lockUser(user);
					String lock="Your account has been locked!";
					session.invalidate();
					return new ModelAndView("index","msg",lock);
				}
				catch (BankingException e)
				{
					return new ModelAndView("index","msg","Account Not Locked!!!!");
				}

			}
		}

	}
	/*@RequestMapping(value="/knowCredentials",method=RequestMethod.POST)
	public ModelAndView verifyCustomer(@ModelAttribute("customerRequest")CustomerRequests cr,HttpServletRequest req)
	{
		try
		{
			request=req;
			session=req.getSession();
			CustomerRequests crs=bankService.verifyCustomer(cr);
			if(cr.getStatus().equalsIgnoreCase("open"))
			{
				session.setAttribute("customerReq", cr);
				return new ModelAndView("verifyCredential","cr",cr);
			}
			else
			{
				return new ModelAndView("index","msg","Your Request is still opened");
			}

		}
		catch(BankingException e)
		{
			return new ModelAndView("index","msg","You have wrong credentials");
		}
	}
	@RequestMapping(value="/showCredentials",method=RequestMethod.POST)
	public ModelAndView showCustomer(@ModelAttribute("customerRequest")CustomerRequests cr,HttpServletRequest req)
	{
		try
		{
			CustomerRequests crs=bankService.verifyCustomer(cr);
			if(cr.getStatus().equalsIgnoreCase("open"))
			{
				session.setAttribute("customerReq", cr);
				return new ModelAndView("verifyCredential","cr",cr);
			}
			else
			{
				return new ModelAndView("index","msg","Your Request is still opened");
			}

		}
		catch(BankingException e)
		{
			return new ModelAndView("index","msg","You have wrong credentials");
		}
	}*/
	
}
