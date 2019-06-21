package com.revature.repository;

import com.revature.model.User;

public interface UserRepository {
	
	
	public boolean createUser(User user);
	public boolean ValidateLogin(String username, String password);

}
