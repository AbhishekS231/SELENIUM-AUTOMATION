package pom;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}

	@Test
	void login() {
		LoginPage lp = new LoginPage(driver);
		String url = driver.getCurrentUrl();
		System.out.println("The driver page url is=" + url);
		String title = driver.getTitle();
		System.out.println("The driver page title is=" + title);
		String windowId = driver.getWindowHandle();
		System.out.println("The parent window id is=" + windowId);

		lp.userName("Admin");
		lp.userPwd("admin123");
		lp.btn_Login.click();
		Set<String> windowIDs=driver.getWindowHandles();
		System.out.println("*************************************************");
		System.out.println("The windows IDs are="+windowIDs);
		
	}

	@AfterClass
	void tearDown() {
		//driver.quit();
	}
}
