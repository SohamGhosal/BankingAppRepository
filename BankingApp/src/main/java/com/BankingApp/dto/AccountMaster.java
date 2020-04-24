package com.BankingApp.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Proxy(lazy=false)
@Data
public class AccountMaster implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3679896461361914787L;
	@Id
	private String accountId;
	private String accountType;
	private Long accountBal;
	private LocalDate openDate;
	private String reqId;
	private String chequeStatus;
}
