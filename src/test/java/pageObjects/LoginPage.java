package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//input[@placeholder='User Name or Email']")
	WebElement userNameOrEmail;

	@FindBy(xpath = "//input[@placeholder='Enter your Password']")
	WebElement enterYourPassword;

	@FindBy(xpath = "//span[normalize-space()='Remember Me']")
	WebElement rememberMe;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement logIn;

	// Methods

	public void clickuserNameOrEmail(String email) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(userNameOrEmail)); // Wait for the element to be visible
		userNameOrEmail.clear();
		userNameOrEmail.sendKeys(email);
	}

	public void clickenterYourPassword(String pwd) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(enterYourPassword)); // Wait for the element to be visible
		enterYourPassword.clear();
		enterYourPassword.sendKeys(pwd);
		
	}

	public void clickrememberMe() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(rememberMe)); // Wait for the element to be clickable
		rememberMe.click();
	}

	public void clicklogIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logIn)); // Wait for the element to be clickable
		logIn.click();
	}
}
