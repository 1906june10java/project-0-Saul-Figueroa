package com.revature.exception;

public class NegativeDepositException extends RuntimeException{
	
	public NegativeDepositException() {
		super("You are trying to deposit a negative balance, session finalized");
	}

}
