package com.bankingapp.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Transactions implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7170595873076698277L;
	@EmbeddedId
	private TransactionId transactionId;
	private String transDesc;
	private LocalDate transDate;
	private Long transAmt;
	private Integer accountNo;
	public TransactionId getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(TransactionId transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransDesc() {
		return transDesc;
	}
	public void setTransDesc(String transDesc) {
		this.transDesc = transDesc;
	}
	public LocalDate getTransDate() {
		return transDate;
	}
	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}
	public Long getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(Long transAmt) {
		this.transAmt = transAmt;
	}
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	
}
