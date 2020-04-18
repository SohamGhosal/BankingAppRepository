package com.BankingApp.dao;

import com.BankingApp.dto.AccountMaster;
import com.BankingApp.dto.PayeeTable;
import com.BankingApp.dto.TransactionId;
import com.BankingApp.dto.Transactions;
import com.BankingApp.exception.BankingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository("fundTransferDao")
@Transactional
@Slf4j
public class FundTransferDAO implements IFundTransferDAO {
	@PersistenceContext
	EntityManager em;
	@Override
	public boolean checkAccId(int accid) throws BankingException
	{
		try {
			AccountMaster am =em.getReference(AccountMaster.class, accid);
			if(am.getAccountId()!=0)
				return true;
			else
				return false;
		} catch(PersistenceException e) {
			throw new BankingException("No Account Found!");
		}
	}
	@Override
	public void transferFund(PayeeTable pt)
	{
		try
		{
			AccountMaster acc=new AccountMaster();
			acc=em.getReference(AccountMaster.class, pt.getAccId());
			long accBal=acc.getAccountBal();
			acc.setAccountBal(accBal-pt.getAmount());
			em.merge(acc);
			int tid=Integer.parseInt(RandomStringUtils.randomNumeric(6,6));
			Transactions tr1=new Transactions();
			tr1.setAccountNo(acc.getAccountId());
			tr1.setTransAmt(pt.getAmount());
			tr1.setTransDate(LocalDate.now());
			tr1.setTransDesc("Debit from Account No "+pt.getPayeeAccId());
			TransactionId t1=new TransactionId();
			t1.setTransId(tid);
			t1.setTransType("d");
			tr1.setTransactionId(t1);
			em.persist(tr1);
			em.flush();
			AccountMaster payeeacc=new AccountMaster();
			payeeacc=em.getReference(AccountMaster.class, pt.getPayeeAccId());
			long payeeAccBal=payeeacc.getAccountBal();
			payeeacc.setAccountBal(payeeAccBal+pt.getAmount());
			em.merge(payeeacc);
			Transactions tr2=new Transactions();
			tr2.setAccountNo(payeeacc.getAccountId());
			tr2.setTransAmt(pt.getAmount());
			tr2.setTransDate(LocalDate.now());
			tr2.setTransDesc("Credit to Account No "+pt.getAccId());
			TransactionId t2=new TransactionId();
			t2.setTransId(tid);
			t2.setTransType("c");
			tr2.setTransactionId(t2);
			em.persist(tr2);
			em.flush();
			log.info("Transaction Successful!");
		}
		catch (BankingException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
