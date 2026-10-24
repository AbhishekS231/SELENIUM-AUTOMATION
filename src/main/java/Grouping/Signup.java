package Grouping;

import org.testng.annotations.Test;

public class Signup {
	@Test(priority=1,groups= {"Regression"})
	void signUpByEmail()
	{
		System.out.println("This is Signup by email");
	}
	@Test(priority=2,groups= {"Regression"})
	void signUpByFacebook()
	{
		System.out.println("This is signUp by facebook");
	}
	@Test(priority=3,groups= {"Regression"})
	void signUpByTwitter()
	{
		System.out.println("This is signup by twitter");
	}
}
