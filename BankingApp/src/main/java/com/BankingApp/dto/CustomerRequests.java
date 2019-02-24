package com.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}