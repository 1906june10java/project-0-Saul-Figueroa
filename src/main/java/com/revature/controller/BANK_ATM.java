package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exception.NumNotValidException;
import com.revature.model.Account;
import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.repository.AccountRepositoryJDBC;
import com.revature.repository.UserRepositoryJDBC;
import com.revature.service.Validations;

public class BANK_ATM {
	
	public static void main(String[] args) {
		welcomeBank();

		
	}
	
	public static void welcomeBank()
	{

		Scanner sc = new Scanner(System.in);
		int option=0;
		
		UserRepositoryJDBC repository = new UserRepositoryJDBC();
		Validations validation = new Validations();
		User user;
		int parameterIndex =0;
		while (true) {
			
				try {

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
					
					
				} catch (InputMismatchException e) {
					System.out.println("Please enter a number "+e);
					//throw new NumNotValidException("Please enter a number");
					welcomeBank();
				}
				
			
			
			
		}
		
		
	}
		
	public static void callCreateAccount(String username, long id)
	{
		Scanner sc = new Scanner(System.in);
		int option=0;
		long bankID =1;
		long userID = id;
		String name = username;
		AccountRepositoryJDBC repositoryJDBC = new AccountRepositoryJDBC();
		Validations validation = new Validations();
		long accountid =repositoryJDBC.getAccountID(userID);
		
		while(true) {
			
			try {
				System.out.println("Welcome "+username+" please enter your choice ");
				System.out.println("1. Read Bank policies");
				System.out.println("2. Create a new account");
				System.out.println("3. Deposit");
				System.out.println("4. Withdraw");
				System.out.println("5. View balance");
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
					
					repositoryJDBC.createAccount(new Account("Checking account",balance), bankID, userID);
					break;
					
				case 3:
					
					if (repositoryJDBC.verifyAccount(userID) == true) {
						System.out.println("Enter the amount of money to be deposited");
						double deposit = sc.nextDouble();
						
						repositoryJDBC.deposit(deposit, userID);
						//inserting transaction
						repositoryJDBC.insertTransaction(new Transaction(deposit, "New deposit"), accountid, 1);
						
					} else {
						System.err.println("You have to create an account");

					}
		
					break;
					
				case 4:
					
					double dbBalance=repositoryJDBC.getJustBalance(userID);
					
					if (repositoryJDBC.verifyAccount(userID) == true) {
						
						System.out.println("Enter the amount of money to be withdrawn");
						double withdraw = sc.nextDouble();
						
						if (validation.validateWithdraw(withdraw, dbBalance)) {
							
							repositoryJDBC.withdraw(withdraw, userID);
							repositoryJDBC.insertTransaction(new Transaction(withdraw, "New withdraw"), accountid, 1);
							
						} else {
							System.err.println("Can not wothdraw more than "+dbBalance);
						}	
						
					} else {
						System.err.println("You have to create  an account");

					}
					
					
					
					 break;
					
				case 5:
					repositoryJDBC.getBalance(userID);
					break;
					
				case 6:
					System.out.println(repositoryJDBC.getTransactions(accountid));
					break;
					
				case 7:
					welcomeBank();
					break;
					
				case 8:
					System.out.println("Thanks for your preference :) ");
					System.exit(1);
					break;
					
				default:
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number");
				callCreateAccount(username, userID);
			}
					
		}			
		
	}
	
	
}
