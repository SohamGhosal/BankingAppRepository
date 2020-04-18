package com.BankingApp.dto;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Data
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