package com.BankingApp.service;

import com.BankingApp.dto.PayeeTable;
import com.BankingApp.exception.BankingException;

public interface IFundTransferService {
	public boolean checkAccId(String accid) throws BankingException;
	public void transferFund(PayeeTable pt) throws BankingException;
}
