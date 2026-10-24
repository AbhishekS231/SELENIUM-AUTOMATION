package Wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpicitWait {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement textUsrname = mywait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/descendant::input[1]")));
		textUsrname.sendKeys("Admin");

		WebElement textPswd = mywait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@name='password' and @placeholder='Password']")));
		textPswd.sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button')]")).click();

		driver.quit();
	}

}
