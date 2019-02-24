package com.BankingApp.dao;

import com.BankingApp.dto.PayeeTable;
import com.BankingApp.exception.BankingException;

public interface IFundTransferDAO {
	public boolean checkAccId(int accid) throws BankingException;
	public void transferFund(PayeeTable pt) throws BankingException;
}
