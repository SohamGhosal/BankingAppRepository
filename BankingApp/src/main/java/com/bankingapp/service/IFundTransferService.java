package com.BankingApp.service;

import com.BankingApp.dto.PayeeTable;
import com.BankingApp.exception.BankingException;

public interface IFundTransferService {
	public boolean checkAccId(int accid) throws BankingException;
	public void transferFund(PayeeTable pt) throws BankingException;
}
