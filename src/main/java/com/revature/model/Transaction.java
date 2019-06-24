package com.revature.model;

import java.util.Date;

public class Transaction {
	
	private double amount;
	private String memo;
	private Date timestamp;
	//The account in which the transaction was performed 
	private Account inAccount;
	
	public Transaction() {}


	public Transaction(double amount, String memo) {
		super();
		this.amount = amount;
		this.memo = memo;
		
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Account getInAccount() {
		return inAccount;
	}

	public void setInAccount(Account inAccount) {
		this.inAccount = inAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((inAccount == null) ? 0 : inAccount.hashCode());
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (inAccount == null) {
			if (other.inAccount != null)
				return false;
		} else if (!inAccount.equals(other.inAccount))
			return false;
		if (memo == null) {
			if (other.memo != null)
				return false;
		} else if (!memo.equals(other.memo))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", memo=" + memo + ", timestamp=" + timestamp + ", inAccount="
				+ inAccount + "]";
	}
	
	
	
	
	
}
