import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.repository.AccountRepositoryJDBC;
import com.revature.repository.UserRepositoryJDBC;
import com.revature.service.Validations;

public class JunitTests {
	
	
	private final static Validations validation = new Validations();
	private final UserRepositoryJDBC repository = new UserRepositoryJDBC();
	
	//
	@Test
	public void deposit()
	{
		final double amount = 10;
		assertEquals(true, validation.validateDeposit(amount));
		
	}
	
	//
	@Test
	public void withdraw()
	{
		final double balance=400;
		final double amount=100;
		
		assertEquals(true, validation.validateWithdraw(amount, balance));
		
	}
	
	@Test
	public void validateLogin() 
	{
		final String username = "SAULEFF";
		final String password="1357";
		
		assertEquals(true, repository.ValidateLogin(username, password));
		
	}
	
	
	
	

}
