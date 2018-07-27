package com.bankingapp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;
@Entity
@Proxy(lazy=false)
public class BankAdmin {
	@Id
	private String adminId;
	private String adminPassword;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
