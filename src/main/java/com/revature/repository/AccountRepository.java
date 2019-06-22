package com.revature.repository;

import java.util.List;

import com.revature.model.Account;

public interface AccountRepository {
	
	public boolean createAccount(Account account, long bankid, long userid);
	
	public boolean deposit(double amount, long userid);
	public boolean withdraw(double amount, long userid);
	public List<Account> getBalance(long userid);
	
	
	

}
