package com.BankingApp.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FundTransfer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6018723658516846599L;
	private Integer fundTransId;
	private Integer accId;
	private Integer payeeAccId;
	private LocalDate transDate;
	private Long transAmt;
}