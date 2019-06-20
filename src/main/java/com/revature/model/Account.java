package com.revature.model;

import java.util.ArrayList;

public class Account {

	private String name;
	private int balance;
	private String ID;
	private User holder;
	//A list of transactions for this account
	private ArrayList<Transaction> transactions;
	
	
	public Account(String name, String holder, Bank bank) {
		
	}
	
}
