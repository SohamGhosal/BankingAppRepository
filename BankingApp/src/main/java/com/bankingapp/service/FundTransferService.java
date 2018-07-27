package com.bankingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapp.dao.IFundTransferDAO;
import com.bankingapp.dto.PayeeTable;
import com.bankingapp.exception.BankingException;
@Service("fundTransferService")
@Transactional
public class FundTransferService implements IFundTransferService {
	@Autowired
	IFundTransferDAO fundTransferDao;
	@Override
	public boolean checkAccId(int accid) throws BankingException
	{
		return fundTransferDao.checkAccId(accid);
	}
	@Override
	public void transferFund(PayeeTable pt) throws BankingException
	{
		fundTransferDao.transferFund(pt);
	}
}
