package testng;

import org.testng.annotations.Test;

public class MyFirstTest {

	// open application
	// Login
	// Logout
	
	@Test(priority=1)
	void openApp()
	{
		System.out.println("Open the application");
	}
	@Test(priority=2)
	void Login()
	{
		System.out.println("Logged in to the appliocation");
	}
	@Test(priority=3)
	void Logout()
	{
		System.out.println("Logout the application");
	}
}
