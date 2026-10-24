package mouseractions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement text1 = driver.findElement(By.xpath("//input[@id='field1']"));
		text1.clear();
		text1.sendKeys("ILoveYou");
		WebElement doubleClick = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		Actions act = new Actions(driver);
		act.doubleClick(doubleClick).perform();
		Thread.sleep(2000);
		WebElement text2 = driver.findElement(By.xpath("//input[@id='field2']"));
		System.out.println(text2.getAttribute("value"));

	}

}
