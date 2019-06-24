package com.revature.service;

import java.util.Scanner;

public class Validations {
	
	
	public boolean validateWithdraw(double amount, double balance)
	{
		if (amount < balance) {
			return true;
		}
		
		return false;
	}
	
	public boolean validateDeposit(double amount) {
		
		if (amount > 0) {
			return true;
		}
		
		return false;
	}

}
