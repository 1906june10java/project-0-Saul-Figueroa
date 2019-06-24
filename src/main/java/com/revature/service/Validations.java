package com.revature.service;

import java.util.Scanner;

public class Validations {
	
	
	public boolean verifyInt(Scanner number)
	{
		
		if (number.hasNextInt()) {
			return true;
		}
		
		return false;
		
	}

}
