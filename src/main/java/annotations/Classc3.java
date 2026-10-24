package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Classc3 {
	@BeforeTest
	void bt() {
		System.out.println("This is before Test Abhishek");
	}

	@AfterTest
	void at() {
		System.out.println("This is after Test Abhishek");
	}

	@BeforeClass
	void bc() {
		System.out.println("This is before class");
	}

	@AfterClass
	void ac() {
		System.out.println("This is after class");
	}

	@BeforeMethod
	void login() {
		System.out.println("This is login");
	}

	@Test(priority = 1)
	void search() {
		System.out.println("This is search");

	}

	@Test(priority = 2)
	void advSearch() {
		System.out.println("This is advanced search");
	}

	@AfterMethod
	void logout() {
		System.out.println("This is logout");
	}
}
