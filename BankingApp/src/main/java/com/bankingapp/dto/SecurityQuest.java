package com.bankingapp.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;
@Entity
@Proxy(lazy=false)
public class SecurityQuest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9109254310476418472L;
	@Id
	private int securityQid;
	private String securityQuest;
	public int getSecurityQid() {
		return securityQid;
	}
	public void setSecurityQid(int securityQid) {
		this.securityQid = securityQid;
	}
	public String getSecurityQuest() {
		return securityQuest;
	}
	public void setSecurityQuest(String securityQuest) {
		this.securityQuest = securityQuest;
	}
	
}
