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
	private Integer payeeAccId;
	private LocalDate transDate;
	private Long transAmt;
	
	public Integer getFundTransId() {
		return fundTransId;
	}
	public void setFundTransId(Integer fundTransId) {
		this.fundTransId = fundTransId;
	}
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	public Integer getPayeeAccId() {
		return payeeAccId;
	}
	public void setPayeeAccId(Integer payeeAccId) {
		this.payeeAccId = payeeAccId;
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
	
}