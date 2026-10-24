package dependencies;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependencies {

	// OpneApp
	// Login
	// search
	// add Search
	// Logout
	
	@Test(priority=1)
	void openApp()
	{
		System.out.println("Open The App");
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	void login()
	{
		System.out.println("login The App");
		Assert.assertTrue(true);
	}
	@Test(priority=3)
	void search()
	{
		System.out.println("search The App");
		Assert.assertTrue(true);
	}
	@Test(priority=4)
	void addSearch()
	{
		System.out.println("addSearch The App");
		Assert.assertTrue(true);
	}
	@Test(priority=5)
	void logout() {
		System.out.println("logout The App");
		Assert.assertTrue(true);
	}
}
