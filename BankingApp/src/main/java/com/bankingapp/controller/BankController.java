package com.bankingapp.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bankingapp.service.GenericBankService;
import com.bankingapp.service.IGenericBankService;

@Controller("/BankingApp") //Using annotation to set the class as controller
public class BankController
{
	private static Logger logger=Logger.getLogger(BankController.class);
	HttpSession session;
	HttpServletRequest request;
	@Autowired
	IGenericBankService bankService=new GenericBankService();
	private static final Random generator = new Random();

	public static int generatePin() {
		logger.info("Pin Generated!");
		return 100000 + generator.nextInt(900000);
	}	

}
