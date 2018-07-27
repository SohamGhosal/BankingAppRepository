package com.bankingapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="users")
@Proxy(lazy=false)
public class User
{
	@Column(name="accountid")
	private Integer accId;
	@Id
	@Min(value=100000,message="Invalid User ID")
	@Max(value=999999,message="Invalid User ID")
	private Integer userId;
	@Column(name="loginpassword")
	private String Password;
	@Column(name="secretquestion")
	private String secretQues;
	@Column(name="answer")
	private String Ans;
	@Column(name="tansactionpassword")
	private String transPassword;
	@Column(name="lockstatus")
	private String lockStatus;
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSecretQues() {
		return secretQues;
	}
	public void setSecretQues(String secretQues) {
		this.secretQues = secretQues;
	}
	public String getAns() {
		return Ans;
	}
	public void setAns(String ans) {
		Ans = ans;
	}
	public String getTransPassword() {
		return transPassword;
	}
	public void setTransPassword(String transPassword) {
		this.transPassword = transPassword;
	}
	public String getLockStatus() {
		return lockStatus;
	}
	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}
}
