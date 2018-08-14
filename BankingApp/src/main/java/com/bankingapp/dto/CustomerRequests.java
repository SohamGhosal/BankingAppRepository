package com.bankingapp.dto;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.annotations.Proxy;
@Entity
@Proxy(lazy=false)
public class CustomerRequests implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5159401544235909396L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="customerreqid")
	private Integer custReqId;
	@Column(name="customername")
	private String custName;
	@Column(unique=true)
	@Email(message="Email is not valid")
	private String email;
	@Column(name="phoneno")
	private String mobileNo;
	private String address;
	@Column(name="pancard")
	private String panNo;
	private String accountType;
	@Column(name="accountbalance")
	private long accountBal;
	private String status;
	private String secretQuest;
	@Column(name="answer")
	private String ans;
	private String chequeStatus;
	
	public Integer getCustReqId() {
		return custReqId;
	}
	public void setCustReqId(Integer custReqId) {
		this.custReqId = custReqId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAccountBal() {
		return accountBal;
	}
	public void setAccountBal(long accountBal) {
		this.accountBal = accountBal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSecretQuest() {
		return secretQuest;
	}
	public void setSecretQuest(String secretQuest) {
		this.secretQuest = secretQuest;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getChequeStatus() {
		return chequeStatus;
	}
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}
}