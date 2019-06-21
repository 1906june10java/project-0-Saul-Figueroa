package com.revature.controller;

import java.util.Scanner;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.repository.UserRepositoryJDBC;

public class BANK_ATM {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int option=0;
		
		UserRepositoryJDBC repository = new UserRepositoryJDBC();
		User user;
		int parameterIndex =0;
		while (true) {
			
			System.out.println("Welcome to Figueroa's bank, please enter your choice");
			System.out.println("1. Sign up");
			System.out.println("2. Log in");
			option = sc.nextInt();
			
			switch (option) {
			case 1:
			System.out.println("Enter the first name:");
			String fName = sc.next();
			
			System.out.println("Enter the last name:");
			String lName = sc.next();
			
			System.out.println("Enter the username (must contain more than 5 characteres)");
			String username = sc.next();
			
			System.out.println("Enter the password");
			String password = sc.next();
			//change once we have the validation methods
			if (true) {
				
				
				repository.createUser(new User(4,fName,lName,username,password));
			}
				break;
				
			case 2:
				System.out.println("Enter username");
				String userName = sc.next();
				System.out.println("Enter password");
				String pass = sc.next();
				
				//repository.ValidateLogin(userName, pass);
			if (repository.ValidateLogin(userName, pass)) {
				callCreateAccount(userName);
			}
				
				
				break;

			default:
				break;
			}
			
		}
		

		
	}
		
	public static void callCreateAccount(String username)
	{
		System.out.println("Welcome "+username);
		
		
		
	}
	

}
