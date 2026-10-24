package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Constructor
	LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Locators

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement txt_username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txt_pwd;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btn_Login;
	// ActionMethods

	void userName(String username) {

		txt_username.sendKeys(username);
	}

	void userPwd(String pwd) {
		txt_pwd.sendKeys(pwd);
	}

	void loginClick() {
		btn_Login.click();
	}
}
