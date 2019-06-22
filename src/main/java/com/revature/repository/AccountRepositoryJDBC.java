package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			
			String sql="INSERT INTO ACCOUNTS VALUES(PK_ACCOUNTS.NEXTVAL,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);

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
	public boolean deposit(double amount, long userid) {
		
		LOGGER.trace("Entering, deposit");
		
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int parameterIndex=0;

			String sql ="UPDATE ACCOUNTS SET A_BALANCE= (A_BALANCE + ?) WHERE U_ID  =?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setDouble(++parameterIndex, amount);
			statement.setLong(++parameterIndex, userid);
			
			if (statement.executeUpdate() > 0) {
				LOGGER.trace(amount+ " successfully deposited in your account");
				return true;
			}
			
			
		} catch (SQLException e) {
			LOGGER.error("Could not make the deposit "+e);
		}
		return false;
	}

	@Override
	public boolean withdraw(double amount, long userid) {
		
		LOGGER.trace("Entering, withdraw");
		
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int parameterIndex=0;

			String sql ="UPDATE ACCOUNTS SET A_BALANCE= (A_BALANCE - ?) WHERE U_ID  =?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setDouble(++parameterIndex, amount);
			statement.setLong(++parameterIndex, userid);
			
			if (statement.executeUpdate() > 0) {
				LOGGER.trace(amount+ " successfully withdrawn");
				return true;
			}
			
			
		} catch (SQLException e) {
			LOGGER.error("Could not make the withdraw "+e);
		}
		return false;
	}

	@Override
	public List<Account> getBalance(long userid) {
		LOGGER.trace("Entering, view balance");
		System.out.println(userid);
		try(Connection connection = ConnectionUtil.getConnection()){
			int parameterIndex=0;
			String sql="SELECT * FROM ACCOUNTS WHERE U_ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(++parameterIndex, userid);

			ResultSet result = statement.executeQuery();
			
			List<Account> account = new ArrayList<>();
			
			while (result.next()) {
				account.add(new Account(	
						result.getString("A_NAME"),
						result.getDouble("A_BALANCE")
						))			
						;
				
			}
			System.out.println(account);
			return account;
		} catch (SQLException e) {
			LOGGER.error("Could not get balance "+e);
		}
		
		
		return null;
	}

	

	
}
