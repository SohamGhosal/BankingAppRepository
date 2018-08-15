package com.bankingapp.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class BankAdmin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7121055691570123861L;
	@Id
	private String adminId;
	@NotBlank
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
