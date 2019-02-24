package com.BankingApp.controller;

import com.BankingApp.service.GenericBankService;
import com.BankingApp.service.IGenericBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller("/BankingApp")
public class BankController
{
	HttpServletRequest request=null;
	HttpSession session;
	@Autowired
	IGenericBankService bankService=new GenericBankService();
	
}
