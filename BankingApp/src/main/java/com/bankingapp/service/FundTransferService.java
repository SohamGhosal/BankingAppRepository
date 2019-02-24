package com.BankingApp.service;

import com.BankingApp.dao.IFundTransferDAO;
import com.BankingApp.dto.PayeeTable;
import com.BankingApp.exception.BankingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
