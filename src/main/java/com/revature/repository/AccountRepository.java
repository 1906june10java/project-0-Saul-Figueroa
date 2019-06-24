package com.revature.repository;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.Transaction;

public interface AccountRepository {
	
	public boolean createAccount(Account account, long bankid, long userid);
	
	public boolean deposit(double amount, long userid);
	public boolean withdraw(double amount, long userid);
	public List<Account> getBalance(long userid);
	
	//verify account
	public boolean verifyAccount(long userid);
	//get account id
	public long getAccountID(long userid);
	//Transactions
	public boolean insertTransaction(Transaction transaction, long accountid, long type);
	//get transactions
	public List<Transaction> getTransactions(long accountid);
	
	//get only balance
	public double getJustBalance(long userid);
	

}
