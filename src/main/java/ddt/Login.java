package ddt;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		String filePath = System.getProperty("user.dir") + "\\TestData\\Login.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		System.out.println("row count==" + rows);
		for (int i = 1; i <= rows; i++) {
			// Read data from Excel
			String Username = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String Password = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			System.out.println(Username);
			System.out.println(Password);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait for the Username field to be visible
			WebElement UsernameField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));

			// Wait for the Password field to be visible
			WebElement PasswordField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));

			// Now you can interact with the fields
			UsernameField.sendKeys(Username);
			PasswordField.sendKeys(Password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

		}
	}
}
