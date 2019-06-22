package com.revature.controller;

import java.util.Scanner;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.repository.AccountRepositoryJDBC;
import com.revature.repository.UserRepositoryJDBC;

public class BANK_ATM {
	
	public static void main(String[] args) {
		welcomeBank();

		
	}
	
	public static void welcomeBank()
	{

		Scanner sc = new Scanner(System.in);
		int option=0;
		
		UserRepositoryJDBC repository = new UserRepositoryJDBC();
		User user;
		int parameterIndex =0;
		while (true) {
			
			System.out.println("Welcome to Figueroa's bank, please enter your choice");
			System.out.println("1. Sign up");
			System.out.println("2. Log in");
			System.out.println("3. Exit");
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
				
				
				repository.createUser(new User(fName,lName,username,password));
			}
				break;
				
			case 2:
				System.out.println("Enter username");
				String userName = sc.next();
				System.out.println("Enter password");
				String pass = sc.next();
				
				long userid = repository.getUserID(userName, pass);
				System.out.println("ID "+userid);
				//repository.ValidateLogin(userName, pass);
			if (repository.ValidateLogin(userName, pass)) {
				callCreateAccount(userName,userid);
			}
				
				
				break;
				
			case 3:
				System.out.println("Thanks for your preference :) ");
				System.exit(0);
				break;

			default:
				break;
			}
			
		}
		
		
	}
		
	public static void callCreateAccount(String username, long id)
	{
		Scanner sc = new Scanner(System.in);
		int option=0;
		long bankID =1;
		long userID = id;
		AccountRepositoryJDBC repositoryJDBC = new AccountRepositoryJDBC();
		
		while(true) {
			
			System.out.println("Welcome "+username+" please enter your choice ");
			System.out.println("1. Read Bank policies");
			System.out.println("2. Create a new checking account");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. View balacne");
			System.out.println("6. View transactions");
			System.out.println("7. Go back");
			System.out.println("8. Exit");
			option = sc.nextInt();
			
			switch (option) {
			case 1:
				System.out.println("Hello, welcome to our bank");
				break;
				
			case 2:
				System.out.println("Creating a new checking account");
				System.out.println("Please enter the initial balance");
				double balance = sc.nextDouble();
				
				repositoryJDBC.createAccount(new Account("Checking account",balance), bankID, id);
	
				
				break;
				
			case 3:
				System.out.println("Enter the amount of money to be deposited");
				double deposit = sc.nextDouble();
				repositoryJDBC.deposit(deposit, userID);
	
				break;
				
			case 4:
				
				System.out.println("Enter the amount of money to be withdrawn");
				double withdraw = sc.nextDouble();
				
				repositoryJDBC.withdraw(withdraw, userID);
				
				 break;
				
			case 5:
				repositoryJDBC.getBalance(userID);

			default:
				break;
			}

			
		}
				
		
	}
	

}
