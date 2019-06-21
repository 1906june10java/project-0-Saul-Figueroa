package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.model.Account;
import com.revature.util.ConnectionUtil;

public class AccountRepositoryJDBC implements AccountRepository{
	
	private static final Logger LOGGER = Logger.getLogger(UserRepositoryJDBC.class);

	@Override
	public boolean createAccount(Account account, long bankid, long userid) {
	
		LOGGER.trace("Entering, creating new account "+account);
		
		try(Connection connection = ConnectionUtil.getConnection()){
			int parameterIndex =0;
			
			String sql=("INSERT INTO ACCOUNTS VALUES(?,?,?,?,?)");
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setLong(++parameterIndex, account.getAccountId());
			statement.setString(++parameterIndex, account.getName());
			statement.setDouble(++parameterIndex, account.getBalance());
			statement.setLong(++parameterIndex, bankid);
			statement.setLong(++parameterIndex, userid);
			
			if (statement.executeUpdate() > 0) {
				LOGGER.trace("Account created successfully "+account);
				return true;
				
			}
						
		} catch (SQLException e) {
			LOGGER.error("Could not create account "+e);
		}
		
		return false;
	}

	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
