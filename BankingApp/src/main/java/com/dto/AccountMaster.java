package com.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Proxy(lazy=false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountMaster implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3679896461361914787L;
	@Id
	private Integer accountId;
	private String accountType;
	private Long accountBal;
	private LocalDate openDate;
	private Integer reqId;
	private String chequeStatus;
}
