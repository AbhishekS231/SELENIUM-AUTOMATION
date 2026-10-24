package frames;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://ui.vision/demo/webtest/frames/");
//Frame1		

		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		WebElement textframe1 = driver.findElement(By.xpath("//input[@name='mytext1']"));
		textframe1.sendKeys("I Love You");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("The frame1 input text=" + textframe1.getText());
		driver.switchTo().defaultContent();
//Frame2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("I Love You Too");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().defaultContent();

//Frame3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Lets Go for a coffe date");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//I-frame
		driver.switchTo().frame(0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement text = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='I am a human']")));
		// Scroll the element into view using JavaScript
		js.executeScript("arguments[0].scrollIntoView(true);", text);
		Thread.sleep(5000);
		// text.click();
		System.out.println("The radio button text is=" + text.getText());
		// Click the element using JavaScript
		js.executeScript("arguments[0].click();", text);

		List<WebElement> checkboxes = driver.findElements(By.xpath("//span[@class='aDTYNe snByac n5vBHf OIC90c']"));
		for (int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
			System.out.println("checkboxes text are=" + checkboxes.get(i).getText());
		}
		Thread.sleep(5000);

		driver.close();
	}

}
