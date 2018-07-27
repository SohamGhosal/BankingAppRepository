package com.bankingapp.service;

import com.bankingapp.dto.PayeeTable;
import com.bankingapp.exception.BankingException;

public interface IFundTransferService {
	public boolean checkAccId(int accid) throws BankingException;
	public void transferFund(PayeeTable pt) throws BankingException;
}
