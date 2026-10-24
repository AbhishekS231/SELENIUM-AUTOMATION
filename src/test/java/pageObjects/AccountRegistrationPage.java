package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement emailuser;

	@FindBy(xpath = "//input[@id='current_password']")
	WebElement yourPassword;

	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement confirmPassword;

	@FindBy(xpath = "//div[5]//div[1]//label[1]//span[1]")
	WebElement iHaveAReferralCode;

	@FindBy(xpath = "//input[@placeholder='Please enter referral code']")
	WebElement pleaseEnterReferralCode;

	@FindBy(xpath = "//div[7]//div[1]//label[1]//span[1]")
	WebElement iAgreeToTheProsMarketplac;

	@FindBy(xpath = "//button[normalize-space()='Create an account']")
	WebElement createAnAccount;

// Validation Message
	@FindBy(xpath = "//h3[normalize-space()='Thanks for Registering With Us!']")
	WebElement thanksForRegisteringWithUs;

	// Action Methods
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void setUsername(String uname) {
		username.sendKeys(uname);
	}

	public void setEmail(String email) {
		emailuser.sendKeys(email);
	}

	public void setpassword(String pwd) {
		yourPassword.sendKeys(pwd);
	}

	public void setConpassword(String conpwd) {
		confirmPassword.sendKeys(conpwd);
	}

	public void setiHaveAReferralCode() {
		iHaveAReferralCode.click();
	}

	public void setpleaseEnterReferralCode(String refCode) {
		pleaseEnterReferralCode.sendKeys(refCode);

	}

	public void setiAgreeToTheProsMarketplac() {
		iAgreeToTheProsMarketplac.click();
	}

	public void buttoncreateAnAccount() {
		createAnAccount.click();
	}

	public String getConfMsg() {
		try {
			return thanksForRegisteringWithUs.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
