package com.BankingApp.dto;

import lombok.*;

@Data
public class PayeeTable
{
	private String accId;
	private String payeeAccId;
	private Long amount;
}
