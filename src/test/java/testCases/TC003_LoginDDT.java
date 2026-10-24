package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
	public void verifyLoginDDT(String email, String password, String expectedResult) throws IOException {
		DataProviders dp = new DataProviders();
		logger.info("data" + dp.getData().toString());

		logger.info("*********** Starting TC003_LoginDDT ***********");

		try {
			HomePage homePage = new HomePage(driver);
			if (homePage.selectYourRole.getText().contains("Select Your Role!")) {
				logger.info("Role displayed");
				homePage.clickAnEmployer();
				homePage.clickProceedFurther();
			}
			homePage.clickLogin();

			logger.info("Perform Login");
			System.out.println("email" + email);
			System.out.println("password" + password);
			// Perform Login
			LoginPage loginPage = new LoginPage(driver);
			loginPage.clickuserNameOrEmail(email);
			loginPage.clickenterYourPassword(password);
			// loginPage.clickrememberMe();
			loginPage.clicklogIn();
			logger.info("login done here");

			// Verify Login Outcome
			logger.info("Verify Login");
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean isMyAccountPageDisplayed = myAccountPage.isMyASccountPageExist();
			logger.info("My account validation");
			if (expectedResult.equalsIgnoreCase("valid")) {
				if (isMyAccountPageDisplayed) {
					logger.info("Login successful with valid credentials.");
					myAccountPage.clickProfile();
					myAccountPage.clickLogout();

					Assert.assertTrue(true);
				} else {
					logger.error("Login failed with valid credentials.");
					Assert.fail("Login failed with valid credentials.");
				}
			} else if (expectedResult.equalsIgnoreCase("invalid")) {
				if (isMyAccountPageDisplayed) {
					logger.error("Login succeeded with invalid credentials.");
					myAccountPage.clickProfile();
					myAccountPage.clickLogout();

					Assert.fail("Login succeeded with invalid credentials.");
				} else {
					logger.info("Login failed as expected with invalid credentials.");
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			logger.error("Test case failed due to an exception: " + e.getMessage());
			Assert.fail("Test case failed due to an exception.");
		}

		logger.info("*********** Finished TC003_LoginDDT ***********");
	}

}
