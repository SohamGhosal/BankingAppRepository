package com.bankingapp.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="accountmaster")
@Proxy(lazy=false)
public class AccountMaster
{
	@Id
	private Integer accountId;
	private String accountType;
	@Column(name="accountbalance")
	private Long accountBal;
	private Date openDate;
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
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
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
