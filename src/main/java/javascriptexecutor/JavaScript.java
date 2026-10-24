package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
// Scroll the page by pixel
		// js.executeScript("window.scrollBy(0,600)", "");
		// System.out.println(js.executeScript("return window.pageYOffset;"));
// Scroll the page till the end

		/*
		 * js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 * js.executeScript("window.scrollBy(0,600)", "");
		 * System.out.println(js.executeScript("return window.pageYOffset;"));
		 */
// Scroll By visible element
		WebElement radioButton = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
		js.executeScript("arguments[0].scrollIntoView();", radioButton);
		radioButton.click();

	}

}
