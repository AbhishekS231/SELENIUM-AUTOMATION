package Grouping;

import org.testng.annotations.Test;

public class Payment {

	@Test(priority=1,groups= {"Sanity","Regression","Functional"})
	void PaymentByDollar()
	{
		System.out.println("Payment By Dollars");
	}
	@Test(priority=1,groups= {"Sanity","Regression","Functional"})
	void PaymentByRuppes()
	{
		System.out.println("Payment By Rupees");
	}
	
}
