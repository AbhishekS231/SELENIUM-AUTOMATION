package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Locate the dropdown element
		WebElement dropdownElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='country']")));

		// Scroll the dropdown element into view using JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", dropdownElement);

		// Create a Select object
		Select dropdown = new Select(dropdownElement);

		// How many option in dropdown list

		List<WebElement> options = dropdown.getOptions();
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
		System.out.println("***************************************");
		// Select the option "France" by visible text
		dropdown.selectByVisibleText("France");
        
		// Optionally, print the selected option
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		System.out.println("Selected option: " + selectedOption.getText());
		driver.close();
	}

}
