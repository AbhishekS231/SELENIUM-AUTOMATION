package parameterization;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest {

	WebDriver driver;

	@BeforeClass
	void setUp() {
		// Initialize the Chrome WebDriver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "dp")
	void login(String username, String password) throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// Check if login was successful
		boolean status = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	// Correct the DataProvider annotation to match the test reference
	@DataProvider(name = "dp")
	public Object[][] loginData() {
		return new Object[][] { { "Admin1", "admin123" }, { "Admin3", "admin123" }, { "Admin9", "admin123" },
				{ "Admin", "admin123" } };
	}

	@AfterClass
	void tearDown() {
		driver.quit();
		}
	}
