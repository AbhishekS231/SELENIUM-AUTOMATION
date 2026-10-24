package Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class XpathByAxix {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/descendant::input[1]")).sendKeys("Admin");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']")).sendKeys("admin123");
        Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button')]")).click();
        
		//driver.close();
		

	}

}
