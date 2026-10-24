package alerts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		URL myurl = new URL("https://the-internet.herokuapp.com/javascript_alerts");
		driver.navigate().to(myurl);

// Normal Alert: OK
		/*
		 * driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click()
		 * ; Alert myalert = driver.switchTo().alert(); Thread.sleep(5000);
		 * System.out.println(myalert.getText()); myalert.accept();
		 */
// Confirmation Alert Ok and Cancel	
		/*
		 * driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click
		 * (); Alert myalert = driver.switchTo().alert(); Thread.sleep(5000);
		 * System.out.println(myalert.getText()); //myalert.accept(); myalert.dismiss();
		 */

// Prompt alert With text and confirmation
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert myalert = driver.switchTo().alert();
		Thread.sleep(5000);
		System.out.println(myalert.getText());
		myalert.sendKeys("Welcome");
		myalert.accept();
		//myalert.dismiss();
		Thread.sleep(5000);
		driver.close();

	}

}
