package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserRepositoryJDBC implements UserRepository{
	
	private static final Logger LOGGER = Logger.getLogger(UserRepositoryJDBC.class);

	@Override
	public boolean createUser(User user) {
		LOGGER.trace("Entering, create new user "+user);
		
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int parameterIndex=0;
			String sql="INSERT INTO USERS VALUES(PK_USERS.NEXTVAL,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(++parameterIndex, user.getFisrtName());
			statement.setString(++parameterIndex, user.getLastName());
			statement.setString(++parameterIndex, user.getUsername());
			statement.setString(++parameterIndex, user.getPassword());
			
			if (statement.executeUpdate() > 0) {
				LOGGER.trace("User inserted successfully");
				return true;
			}
			
		} catch (SQLException e) {
			LOGGER.error("Could not create the user "+e);
		}
		
		return false;
	}

	@Override
	public boolean ValidateLogin(String username, String password) {
		LOGGER.trace("Entering, validate login with parameters "+username+" "+password);
		int parameterIndex =0;
		try(Connection connection = ConnectionUtil.getConnection())
		{
			String sql ="SELECT * FROM USERS WHERE U_USERNAME = ? and U_PIN =?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(++parameterIndex, username);
			statement.setString(++parameterIndex, password);
			
			ResultSet result = statement.executeQuery();
			
			
			
			if (result.next()) {
				LOGGER.trace("Login successfully");
				return true;
			}
			//Return the ID to insert it in the account
			long id =result.getLong(1);
			System.out.println("ID" +id);
			
		} catch (SQLException e) {
			LOGGER.trace("Incorrect username or password, please verify");
		}
		
		return false;
	}

	@Override
	public long getUserID(String username, String password) {
		
		LOGGER.trace("Entering, validate login with parameters "+username+" "+password);
		int parameterIndex =0;
		try(Connection connection = ConnectionUtil.getConnection())
		{
			String sql ="SELECT * FROM USERS WHERE U_USERNAME = ? and U_PIN =?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(++parameterIndex, username);
			statement.setString(++parameterIndex, password);
			
			ResultSet result = statement.executeQuery();
			
			
			
			if (result.next()) {
				//Return the ID to insert it in the account
				long id =result.getLong(1);
				return id;
			}
			
			
		} catch (SQLException e) {
			LOGGER.trace("Incorrect username or password, please verify");
		}
		
		return 0;
	}

	
	
	

}
