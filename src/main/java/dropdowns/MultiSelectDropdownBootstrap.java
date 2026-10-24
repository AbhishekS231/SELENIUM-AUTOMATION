package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiSelectDropdownBootstrap {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");

//Single select drop-down
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 * WebElement dropdownElement =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//select[@id='colors']"))); JavascriptExecutor js = (JavascriptExecutor)
		 * driver; js.executeScript("arguments[0].scrollIntoView(true);",
		 * dropdownElement); dropdownElement.click();
		 */

//inspect single drop-down element
		/*
		 * WebElement text=driver.findElement(By.xpath("//option[@value='blue']"));
		 * text.click(); System.out.println("The single checkbox text="+text.getText());
		 */

//MultiSelection:
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='colors']//option"));
		for (int i = 0; i < options.size(); i++) {

			System.out.println("The total options are=" + options.get(i).getText());
			
			if (options.get(i).getText().equals("Red") || options.get(i).getText().equals("White")) {
				options.get(i).click();
				System.out.println("*************************************************");
				System.out.println("The Last selected option==" + options.get(i).getText());
			}

		}
		driver.close();
	}

}
