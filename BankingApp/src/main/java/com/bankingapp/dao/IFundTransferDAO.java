package com.bankingapp.dao;

import com.bankingapp.dto.PayeeTable;
import com.bankingapp.exception.BankingException;

public interface IFundTransferDAO {
	public boolean checkAccId(int accid) throws BankingException;
	public void transferFund(PayeeTable pt) throws BankingException;
}
