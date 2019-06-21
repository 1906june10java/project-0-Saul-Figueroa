package com.revature.repository;

import com.revature.model.Account;

public interface AccountRepository {
	
	public boolean createAccount(Account account);
	
	public boolean deposit(double amount);
	public boolean withdraw(double amount);
	public Account getBalance();
	
	

}
