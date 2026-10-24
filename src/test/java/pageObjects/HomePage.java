package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

// Locators
	// WebElements
	@FindBy(xpath = "//h1[normalize-space()='Log in']")
	public WebElement logIn;

	@FindBy(xpath = "//h4[normalize-space()='Select Your Role!']")
	public WebElement  selectYourRole;

	@FindBy(xpath = "//span[@aria-hidden='true']")
	WebElement modal;

	@FindBy(xpath = "//div[@class='role-card d-flex justify-content-center gap-3 align-items-center']//div[1]//input[1]")
	WebElement anEmployer;

	@FindBy(xpath = "//button[normalize-space()='Proceed Further']")
	WebElement proceedFurther;

	@FindBy(xpath = "//li[@class='nav-item bor-left d-lg-block d-none ng-star-inserted']//a[@class='nav-link font-weight-bold'][normalize-space()='Login']")
	WebElement login;

	@FindBy(xpath = "//li[@class='nav-item d-lg-block d-none ng-star-inserted']//a[@class='nav-link font-weight-bold'][normalize-space()='Register']")
	WebElement register;

	@FindBy(xpath = "//a[@class='btn common-btn'][normalize-space()='I Want To Hire']")
	WebElement iWantToHire;

	// Methods for interacting with the elements

	public void registerClick() {
		register.click(); // Click the register link
	}

	public void iWantToHireClick() {
		iWantToHire.click(); // Click the 'I Want To Hire' button
	}

	public void modalClick() {
		modal.click(); // Click the modal close button
	}

	public void clickAnEmployer() {
		anEmployer.click(); // Select "An Employer" option
	}

	public void clickProceedFurther() {
		proceedFurther.click(); // Click "Proceed Further" button
	}

	public void clickLogin() {
		login.click(); // Click the login link
	}

}