package com.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayeeTable
{
	private Integer accId;
	private Integer payeeAccId;
	private Long amount;
}
