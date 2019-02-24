package com.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Proxy(lazy=false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5606224771455760704L;
	@Id
	private Integer customerId;
	private Integer accountId;
	private String custName;
	private String email;
	private String address;
	private String panNo;
	private String mobileNo;
}
