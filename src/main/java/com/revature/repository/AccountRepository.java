package com.revature.repository;

import com.revature.model.Account;

public interface AccountRepository {
	
	public boolean createAccount(Account account, long bankid, long userid);
	
	public boolean deposit(double amount);
	public boolean withdraw(double amount);
	public Account getBalance();
	
	

}
