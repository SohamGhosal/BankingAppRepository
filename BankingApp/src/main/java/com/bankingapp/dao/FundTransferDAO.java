package com.bankingapp.dao;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.PayeeTable;
import com.bankingapp.dto.TransactionId;
import com.bankingapp.dto.Transactions;
import com.bankingapp.exception.BankingException;

@Repository("fundTransferDao")
@Transactional
public class FundTransferDAO implements IFundTransferDAO {
	private static Logger logger=Logger.getLogger(FundTransferDAO.class);
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
			t1.settransType("d");
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
			t2.settransType("c");
			tr2.setTransactionId(t2);
			em.persist(tr2);
			em.flush();
			logger.info("Transaction Successful!");
		}
		catch (BankingException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
