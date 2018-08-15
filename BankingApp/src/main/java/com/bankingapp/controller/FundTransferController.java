package com.bankingapp.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.Customer;
import com.bankingapp.dto.PayeeTable;
import com.bankingapp.dto.User;
import com.bankingapp.exception.BankingException;
import com.bankingapp.service.FundTransferService;
import com.bankingapp.service.IFundTransferService;

@Controller("/FundTransfer")
public class FundTransferController extends BankController{
	private static Logger logger=Logger.getLogger(FundTransferController.class);
	@Autowired
	IFundTransferService fundTransferService=new FundTransferService();
	@RequestMapping(value="/FundTrans",method=RequestMethod.POST)
	public ModelAndView completeFundTransfer(@ModelAttribute("trans") PayeeTable trans,@ModelAttribute("customer")Customer customer,@ModelAttribute("accountholder")User us,HttpServletRequest req)
	{
		String Msg=null;
		long avlamt=0;
		session=req.getSession();
		AccountMaster acc=(AccountMaster)session.getAttribute("acc");
		if(acc.getAccountType().equalsIgnoreCase("current"))
		{
			avlamt=acc.getAccountBal()-500;
		}
		else if(acc.getAccountType().equalsIgnoreCase("savings"))
		{
			if(acc.getChequeStatus().equalsIgnoreCase("R")||acc.getChequeStatus().equalsIgnoreCase("Y"))
			{
				avlamt=acc.getAccountBal()-500;
			}
			else
			{
				avlamt=acc.getAccountBal();
			}
		}
		try {
			if(fundTransferService.checkAccId(trans.getPayeeAccId())==false)
			{
				Msg="Wrong Payee info given";
				logger.error(Msg);
				return new ModelAndView("Welcome","msg",Msg);
			}
			else if(fundTransferService.checkAccId(trans.getAccId())==true)
			{
				if(trans.getAmount()<=avlamt)
				{
					if(trans.getAmount()>=100)
					{
						try
						{
							fundTransferService.transferFund(trans);
							Msg="Fund Transfer Done Successfully";
							logger.info(Msg);
							AccountMaster acct=bankService.getAccountDetails(acc.getAccountId());
							session.removeAttribute("acc");
							session.setAttribute("acc", acct);
							return new ModelAndView("Welcome","msg",Msg);
						}
						catch (BankingException e)
						{
							Msg="Error Occured!";
							logger.error(Msg);
							return new ModelAndView("Welcome","msg",Msg);
						}

					}
					else
					{
						Msg="Atleast amount of 100 has to be transferred";
						logger.error(Msg);
						return new ModelAndView("Welcome","msg",Msg);
					}
				}
				else
				{
					Msg="Not Enough Balance";
					logger.error(Msg);
					return new ModelAndView("Welcome","msg",Msg);
				}
			}
		} catch (BankingException e) {
			logger.error(Msg);
			return new ModelAndView("Welcome","msg","Fund Transfer Failed");
		}
		logger.error(Msg);
		return new ModelAndView("Welcome","msg","Transfer Failed");
	}

}
