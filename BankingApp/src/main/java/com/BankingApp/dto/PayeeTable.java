package com.BankingApp.dto;

import lombok.*;

@Data
public class PayeeTable
{
	private Integer accId;
	private Integer payeeAccId;
	private Long amount;
}
