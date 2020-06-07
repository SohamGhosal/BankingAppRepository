package com.BankingApp.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Proxy(lazy=false)
@Data
public class Customer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5606224771455760704L;
	@Id
	private String customerId;
	private String accountId;
	private String custName;
	private String email;
	private String address;
	private String panNo;
	private String mobileNo;
}
