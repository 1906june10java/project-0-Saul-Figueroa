package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			String sql="INSERT INTO USERS VALUES(?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(++parameterIndex, user.getId());
			statement.setString(++parameterIndex, user.getFisrtName());
			statement.setString(++parameterIndex, user.getLastName());
			statement.setString(++parameterIndex, user.getUsername());
			statement.setString(++parameterIndex, user.getPassword());
			
			if (statement.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			LOGGER.error("Could not create the user "+e);
		}
		
		return false;
	}
	
	

}
