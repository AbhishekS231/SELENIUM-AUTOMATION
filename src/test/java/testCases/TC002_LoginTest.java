package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verify_login() {
		logger.info("*********** Starting TC002_LoginTest **********");

		try {
			// Step 1: Navigate to the Home Page
			logger.info("Navigating to the Home Page...");
			HomePage hp = new HomePage(driver);
			hp.clickAnEmployer();
			logger.info("Clicked on 'An Employer' button.");
			hp.clickProceedFurther();
			logger.info("Clicked on 'Proceed Further' button.");
			hp.clickLogin();
			logger.info("Clicked on 'Login' button.");

			// Step 2: Enter Login Details
			logger.info("Navigating to the Login Page...");
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering username/email...");
			lp.clickenterYourPassword(p.getProperty("email"));
			logger.info("Entering password...");
			lp.clickenterYourPassword(p.getProperty("password")); // Fetch password from config
			logger.info("Selecting 'Remember Me' checkbox...");
			lp.clickrememberMe();
			logger.info("Submitting login form...");
			lp.clicklogIn();

			// Step 3: Verify Login and Navigation to My Account Page
			logger.info("Verifying navigation to My Account page...");
			MyAccountPage mcc = new MyAccountPage(driver);
			boolean isAccountPageDisplayed = mcc.isMyASccountPageExist();

			Assert.assertTrue(isAccountPageDisplayed, "Login failed or My Account page is not displayed.");
			logger.info("Login test passed. Successfully navigated to My Account page.");
		} catch (Exception e) {
			logger.error("Login test failed due to an exception: {}", e.getMessage());
			Assert.fail("Login test failed: " + e.getMessage());
		}

		logger.info("*********** Finished TC002_LoginTest **********");
	}
}
