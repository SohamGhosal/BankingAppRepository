package com.bankingapp.dto;
import java.io.Serializable;
import java.time.LocalDate;
public class FundTransfer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6018723658516846599L;
	private Integer fundTransId;
	private Integer accId;
	private int payeeAccId;
	private LocalDate transDate;
	private long transAmt;
	public int getFundTransId() {
		return fundTransId;
	}
	public void setFundTransId(int fundTransId) {
		this.fundTransId = fundTransId;
	}
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	public int getPayeeAccId() {
		return payeeAccId;
	}
	public void setPayeeAccId(int payeeAccId) {
		this.payeeAccId = payeeAccId;
	}
	public LocalDate getTransDate() {
		return transDate;
	}
	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}
	public long getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(long transAmt) {
		this.transAmt = transAmt;
	}
	
}