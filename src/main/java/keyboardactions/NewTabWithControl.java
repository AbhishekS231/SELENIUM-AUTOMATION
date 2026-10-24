package keyboardactions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NewTabWithControl {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		WebElement ragister = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(ragister).keyUp(Keys.CONTROL).perform();
		List<String> ids = new ArrayList(driver.getWindowHandles());
		System.out.println(ids);
		driver.switchTo().window(ids.get(1));
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Aditi");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Malla");
		WebElement dateDropdown = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		Select dateSelect = new Select(dateDropdown);
		dateSelect.selectByVisibleText("14");

		// Locate the month dropdown and select the month
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText("June");

		// Locate the year dropdown and select the year
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByVisibleText("1999");

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("adititlgt05@gmail.com");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Talentelgia.in");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test123");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Test123");
		driver.findElement(By.xpath("//button[@id='register-button']")).click();

	}

}
