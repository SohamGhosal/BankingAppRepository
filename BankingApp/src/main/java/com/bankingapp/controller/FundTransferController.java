package com.bankingapp.controller;

import java.util.List;

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
import com.bankingapp.dto.Transactions;
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
	public ModelAndView completeFundTransfer(@ModelAttribute("trans") PayeeTable trans,@ModelAttribute("customer")Customer customer,@ModelAttribute("accountholder")User us)
	{
		String Msg=null;
		long avlamt=0;

		AccountMaster acc;
		try
		{
			acc = bankService.getAccountDetails(trans.getAccId());
			AccountMaster payeeacc=bankService.getAccountDetails(trans.getPayeeAccId());
		}
		catch (BankingException e)
		{
			String error=e.getMessage();
			return new ModelAndView("Welcome","msg",error);
		}
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
							return new ModelAndView("Welcome","msg",Msg);
						}
						catch (BankingException e)
						{
							return new ModelAndView("Welcome","msg","Error Occurred");
						}

					}
					else
					{
						Msg="Atleast amount of 100 has to be transferred";
						return new ModelAndView("Welcome","msg",Msg);
					}
				}
				else
				{
					Msg="Not Enough Balance";
					return new ModelAndView("Welcome","msg",Msg);
				}
			}
		} catch (BankingException e) {
			return new ModelAndView("Welcome","msg","Fund Transfer Failed");
		}
		return new ModelAndView("Welcome","msg","Transfer Failed");
	}
	
}
