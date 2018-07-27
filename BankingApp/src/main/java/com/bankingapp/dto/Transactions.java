package com.bankingapp.dto;
import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Transactions
{
	@Id
	@Column(name="transactionid")
	private Integer transId;
	@Column(name="transdescription")
	private String transDesc;
	@Column(name="dateoftransaction")
	private Date transDate;
	@Column(name="transactiontype")
	private String transType;
	@Column(name="tranamount")
	private long transAmt;
	@Column(name="accountid")
	private int accountNo;
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public String getTransDesc() {
		return transDesc;
	}
	public void setTransDesc(String transDesc) {
		this.transDesc = transDesc;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public long getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(long transAmt) {
		this.transAmt = transAmt;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
}
