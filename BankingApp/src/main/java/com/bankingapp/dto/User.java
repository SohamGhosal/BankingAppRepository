package com.bankingapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="users")
@Proxy(lazy=false)
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3449124225226660570L;
	private Integer accId;
	@Id
	@Min(value=100000,message="Invalid User ID")
	@Max(value=999999,message="Invalid User ID")
	private Integer userId;
	private String password;
	private String secretQues;
	private String answer;
	private String transPassword;
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
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecretQues() {
		return secretQues;
	}
	public void setSecretQues(String secretQues) {
		this.secretQues = secretQues;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
