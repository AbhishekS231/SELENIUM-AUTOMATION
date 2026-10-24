package shadowdom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		userName.clear();
		userName.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.clear();
		password.sendKeys("admin123");
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		WebElement svgTime = driver.findElement(By.xpath("//a[normalize-space()='']//*[name()='svg']"));
		svgTime.click();
	}

}
