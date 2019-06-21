package com.revature.model;

import java.util.ArrayList;

public class Account {

	private String name;
	private long accountId;
	private double balance;
	private User userId;
	private Bank bankId;
	
	
	
	public Account() {}



	public Account(String name, long accountId, double balance, User userId, Bank bankId) {
		super();
		this.name = name;
		this.accountId = accountId;
		this.balance = balance;
		this.userId = userId;
		this.bankId = bankId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public long getAccountId() {
		return accountId;
	}



	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public User getUserId() {
		return userId;
	}



	public void setUserId(User userId) {
		this.userId = userId;
	}



	public Bank getBankId() {
		return bankId;
	}



	public void setBankId(Bank bankId) {
		this.bankId = bankId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bankId == null) ? 0 : bankId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (bankId == null) {
			if (other.bankId != null)
				return false;
		} else if (!bankId.equals(other.bankId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Account [name=" + name + ", accountId=" + accountId + ", balance=" + balance + ", userId=" + userId
				+ ", bankId=" + bankId + "]";
	}

	
	
}
