package com.revature.controller;

import com.revature.model.User;
import com.revature.repository.UserRepositoryJDBC;

public class BANK_ATM {
	
	public static void main(String[] args) {

		UserRepositoryJDBC repository = new UserRepositoryJDBC();
		repository.createUser(new User(
				2,"Anyeli","Figueroa","cham2008","g1gu3r04A@"
				
				));
	}
		
		
	

}
