package com.BankingApp.service.impl;

import com.BankingApp.dto.AccountMaster;
import com.BankingApp.dto.PayeeTable;
import com.BankingApp.dto.TransactionId;
import com.BankingApp.dto.Transactions;
import com.BankingApp.exception.BankingException;
import com.BankingApp.repository.AccountMasterRepository;
import com.BankingApp.repository.TransactionsRepository;
import com.BankingApp.service.IFundTransferService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service("fundTransferService")
@Transactional
@Slf4j
public class FundTransferService implements IFundTransferService {
	@Autowired
	private AccountMasterRepository accountMasterRepository;
	@Autowired
	private TransactionsRepository transactionsRepository;
	@Override
	public boolean checkAccId(String accid) throws BankingException
	{
		return accountMasterRepository.existsById(accid);
	}
	@Override
	@Transactional
	public void transferFund(PayeeTable pt) throws BankingException
	{
		AccountMaster accountMaster=accountMasterRepository.findById(pt.getAccId()).get();
		accountMaster.setAccountBal(accountMaster.getAccountBal()-pt.getAmount());
		accountMasterRepository.saveAndFlush(accountMaster);
		String transactionId= RandomStringUtils.randomNumeric(6,6);
		Transactions debitTransactions=new Transactions();
		debitTransactions.setAccountNo(accountMaster.getAccountId());
		debitTransactions.setTransAmt(pt.getAmount());
		debitTransactions.setTransDate(LocalDate.now());
		debitTransactions.setTransDesc("Debit from Account No "+pt.getPayeeAccId());
		TransactionId t1=new TransactionId();
		t1.setTransId(transactionId);
		t1.setTransType("Debit");
		debitTransactions.setTransactionId(t1);
		transactionsRepository.saveAndFlush(debitTransactions);
		AccountMaster payeeacc=accountMasterRepository.findById(pt.getPayeeAccId()).get();
		payeeacc.setAccountBal(payeeacc.getAccountBal()+pt.getAmount());
		accountMasterRepository.saveAndFlush(payeeacc);
		Transactions creditTransactions=new Transactions();
		creditTransactions.setAccountNo(payeeacc.getAccountId());
		creditTransactions.setTransAmt(pt.getAmount());
		creditTransactions.setTransDate(LocalDate.now());
		creditTransactions.setTransDesc("Credit to Account No "+pt.getAccId());
		TransactionId t2=new TransactionId();
		t2.setTransId(transactionId);
		t2.setTransType("Credit");
		creditTransactions.setTransactionId(t2);
		transactionsRepository.saveAndFlush(creditTransactions);
		log.info("Transaction Successful!");
	}
}
