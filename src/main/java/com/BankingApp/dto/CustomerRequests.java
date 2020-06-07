package com.BankingApp.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Proxy(lazy=false)
@Data
public class CustomerRequests implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5159401544235909396L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String custReqId;
	private String custName;
	private String email;
	private String mobileNo;
	private String address;
	private String panNo;
	private String accountType;
	private String status;
	private String secretQuest;
	private String answer;
	private String chequeStatus;
}