package com.bankingapp.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bankingapp.dto.AccountMaster;
import com.bankingapp.dto.PayeeTable;
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
		} catch (Exception e) {
			throw new BankingException("No Account Found!");
		}
	}
	@Override
	public void transferFund(PayeeTable pt)
	{
		AccountMaster acc=new AccountMaster();
		LocalDate dt=LocalDate.now();
		Date date=Date.valueOf(dt);
		acc=em.getReference(AccountMaster.class, pt.getAccId());
		long accBal=acc.getAccountBal();
		acc.setAccountBal(accBal-pt.getAmount());
		em.persist(acc);
		int tid1=0;
		try
		{
			do
			{
				tid1=this.getTransId();
				if(this.checkTransId(tid1)==true)
				{
					break;
				}
			}
			while(true);
		}
		catch (BankingException e)
		{
			e.printStackTrace();
		}
		Transactions tr1=new Transactions();
		tr1.setAccountNo(acc.getAccountId());
		tr1.setTransAmt(pt.getAmount());
		tr1.setTransDate(date);
		tr1.setTransDesc("Debit to Account No "+pt.getPayeeAccId());
		tr1.setTransType("d");
		tr1.setTransId(tid1);
		em.persist(tr1);
		AccountMaster payeeacc=new AccountMaster();
		payeeacc=em.getReference(AccountMaster.class, pt.getAccId());
		long payeeAccBal=payeeacc.getAccountBal();
		payeeacc.setAccountBal(payeeAccBal+pt.getAmount());
		em.persist(payeeacc);
		int tid2=0;
		try
		{
			do
			{
				tid2=this.getTransId();
				if(this.checkTransId(tid2)==true)
				{
					break;
				}
			}
			while(true);
		}
		catch (BankingException e)
		{
			System.out.println(e.getMessage());
		}
		Transactions tr2=new Transactions();
		tr2.setAccountNo(payeeacc.getAccountId());
		tr2.setTransAmt(pt.getAmount());
		tr2.setTransDate(date);
		tr2.setTransDesc("Credit from Account No "+pt.getAccId());
		tr2.setTransType("c");
		tr2.setTransId(tid2);
		em.persist(tr2);
		em.flush();
		logger.info("Transaction Successful!");
	}
	public int getTransId()
	{
		Random r=new Random();
		int transid=400000+(int)(r.nextFloat()*521900);
		return transid;
	}

	public boolean checkTransId(int tid) throws BankingException
	{
		boolean res=true;
		try
		{
			Transactions tr=em.getReference(Transactions.class, tid);
			if(tr.getTransId()==0)
			{
				res=true;
			}
			else
			{
				res=false;
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return res;
	}

}
