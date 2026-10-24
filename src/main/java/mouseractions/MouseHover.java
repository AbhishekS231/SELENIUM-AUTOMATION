package mouseractions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.browserstack.com/guide/mouse-hover-in-seleniu");
		driver.manage().window().maximize();
		WebElement dev = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));
		WebElement doc = driver.findElement(By.xpath("//span[normalize-space()='Documentation']"));
		Actions act = new Actions(driver);
		act.moveToElement(dev).moveToElement(doc).click().perform();

	}

}
