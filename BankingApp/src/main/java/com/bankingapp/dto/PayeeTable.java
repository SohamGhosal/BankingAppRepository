package com.bankingapp.dto;
public class PayeeTable
{
	private Integer accId;
	private Integer payeeAccId;
	private Long amount;
	
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
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
