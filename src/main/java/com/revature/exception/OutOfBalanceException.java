package com.revature.exception;

public class OutOfBalanceException extends RuntimeException{
	
	public OutOfBalanceException(double balance) {
		super("You do not have enough balance to perform this transaction, you cannot withdraw more than "+balance+" session finalized");
	}

}
