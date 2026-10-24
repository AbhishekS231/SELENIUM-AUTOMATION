package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRM {

	// open application
	// VerifyLogo
	// Login
	// closeApp
	WebDriver driver;

	@Test(priority = 1)
	void openApp() {
		System.out.println("Open the application");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 2)
	void verifyLogo() {
		System.out.println("Verify Logo");
		boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("logo displayed" + logo);
	}

	@Test(priority = 3)
	void Login() {
		System.out.println("Logged in to the appliocation");
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		userName.clear();
		userName.sendKeys("Admin");
		WebElement pwd = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		pwd.clear();
		pwd.sendKeys(" admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(priority = 4)
	void closeApp() {
		driver.close();
	}
}
