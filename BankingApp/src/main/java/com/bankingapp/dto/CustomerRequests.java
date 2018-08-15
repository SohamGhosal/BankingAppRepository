package com.bankingapp.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	private Integer custReqId;
	private String custName;
	@Email(message="Email is not valid")
	@NotBlank
	private String email;
	@NotBlank
	private String mobileNo;
	@NotBlank
	private String address;
	@NotBlank
	private String panNo;
	@NotBlank
	private String accountType;
	@NotNull
	private Long accountBal;
	@NotBlank
	private String status;
	@NotBlank
	private String secretQuest;
	@NotBlank
	private String answer;
	@NotBlank
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
	public Long getAccountBal() {
		return accountBal;
	}
	public void setAccountBal(Long accountBal) {
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getChequeStatus() {
		return chequeStatus;
	}
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}
	
}