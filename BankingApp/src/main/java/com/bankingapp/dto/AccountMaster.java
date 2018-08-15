package com.bankingapp.dto;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class AccountMaster implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3679896461361914787L;
	@Id
	private Integer accountId;
	private String accountType;
	private Long accountBal;
	private LocalDate openDate;
	private Integer reqId;
	private String chequeStatus;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getAccountBal() {
		return accountBal;
	}
	public void setAccountBal(Long accountBal) {
		this.accountBal = accountBal;
	}
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}
	public Integer getReqId() {
		return reqId;
	}
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	public String getChequeStatus() {
		return chequeStatus;
	}
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}
	
}
