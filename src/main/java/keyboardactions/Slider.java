package keyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		WebElement minRange = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		Actions act = new Actions(driver);
		/*
		 * System.out.println(minRange.getLocation()); act.dragAndDropBy(minRange, 140,
		 * 250).perform(); System.out.println(minRange.getLocation());
		 */

		WebElement maxRange = driver.findElement(By.xpath("//span[2]"));
		System.out.println(maxRange.getLocation());
		act.dragAndDropBy(maxRange, -140, 250).perform();
	}

}
