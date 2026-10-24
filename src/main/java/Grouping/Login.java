package Grouping;

import org.testng.annotations.Test;

public class Login {

	// Sanity
	// Regression
	// {Sanity,Regression}=Functional.
	
// Suite> Test> Class > Methods
	
	@Test(priority=1,groups= {"Sanity"})
	void loginByEmail()
	{
		System.out.println("This is login by email");
	}
	@Test(priority=2,groups= {"Sanity"})
	void loginByFacebook()
	{
		System.out.println("This is login by facebook");
	}
	@Test(priority=3,groups= {"Sanity"})
	void loginByTwitter()
	{
		System.out.println("This is login by twitter");
	}
	
}
