package com.bankingapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.bankingapp.service.GenericBankService;
import com.bankingapp.service.IGenericBankService;

@Controller("/BankingApp")
public class BankController
{
	HttpServletRequest request=null;
	HttpSession session;
	@Autowired
	IGenericBankService bankService=new GenericBankService();
	
}
