package parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTesting {
	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	void setUp(String br) throws InterruptedException {
		switch (br) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser!");
			return;
		}
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	void testLogo() {
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		if (status = true) {
			Assert.assertEquals(status, true);
		}
	}

	@Test(priority = 2)
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}

	@Test(priority = 3)
	void testURL() {
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
}
