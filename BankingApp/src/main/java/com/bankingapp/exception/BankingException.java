package com.bankingapp.exception;

import javax.persistence.PersistenceException;

public class BankingException extends PersistenceException
{

	public BankingException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankingException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BankingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BankingException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
