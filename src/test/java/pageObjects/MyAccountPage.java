package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h4[normalize-space()='Edit my Account Info']")
	WebElement editMyAccountInfo;
	@FindBy(xpath = "//img[@alt='avatar profile icon']")
	WebElement ProfileIcon;
	@FindBy(xpath = "//ul[@class='profile_inner']//span[contains(text(),'Log out')]")
	WebElement logOut;

	public void clickProfile() {
		ProfileIcon.click();
	}

	public void clickLogout() {
		logOut.click();
	}

	public boolean isMyASccountPageExist() {
		try {
			return editMyAccountInfo.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}
}
