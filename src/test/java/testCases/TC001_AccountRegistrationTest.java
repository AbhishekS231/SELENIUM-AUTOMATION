package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_AccountRegistration() {
		logger.info("******** Starting  TC001_AccountRegistrationTest**********");
		// Step 1: Navigate to the home page and start registration
		try {
			HomePage hp = new HomePage(driver);
			logger.info("Clicking on the confirm Modal link ");
			hp.clickAnEmployer();
			hp.clickProceedFurther();

			logger.info("Clicking on the home page link ");
			hp.registerClick(); // Click the register link

			logger.info("Clicking on the register  link ");
			hp.iWantToHireClick(); // Click the 'I want to hire' option

			// Step 2: Fill in account registration details
			AccountRegistrationPage acPage = new AccountRegistrationPage(driver);
			logger.info("Providing the customer details ");

			// Generate random details for registration
			acPage.setFirstName(randomString().toUpperCase()); // Set first name
			acPage.setLastName(randomString().toUpperCase()); // Set last name
			acPage.setUsername(randomAlphaNumeric()); // Set random username
			acPage.setEmail(randomString() + "@mailinator.com"); // Set random email
			String password = randomAlphaNumeric(); // Generate a random password
			acPage.setpassword(password); // Set password
			acPage.setConpassword(password); // Set confirm password

			// Step 3: Referral code section
			acPage.setiHaveAReferralCode(); // Click the 'I have a referral code' checkbox
			acPage.setpleaseEnterReferralCode("PROSP5QSAF69550"); // Set a fixed referral code

			// Step 4: Move focus to the next field (tab out of referral code input)
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.TAB).build().perform(); // Send TAB key to move out of the referral code field

			// Step 5: Agree to the terms and create the account
			acPage.setiAgreeToTheProsMarketplac(); // Check the agreement box
			acPage.buttoncreateAnAccount(); // Click 'Create Account' button

			// Step 6: Verify the confirmation message
			logger.info("validating expected message ");
			String conmsg = acPage.getConfMsg(); // Get the confirmation message
			Assert.assertEquals(conmsg, "Thanks for Registering With Us!"); // Assert the message is correct
		} catch (Exception e) {
			logger.error("Test failed");
			logger.debug("debug logs");
			Assert.fail();
		}
		logger.info("******** Finish  TC001_AccountRegistrationTest**********");
	}

}
