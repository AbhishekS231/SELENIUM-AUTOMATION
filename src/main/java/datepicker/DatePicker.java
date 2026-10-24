package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	static void selectFutureDate(WebDriver driver, String expYear, String expMonth, String expDate) {
		while (true) {
			String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (currMonth.equals(expMonth) && currYear.equals(expYear)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for (WebElement date : allDates) {
			if (date.getText().equals(expDate)) {
				System.out.println(date.getText());
				date.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		String expYear = "2025";
		String expMonth = "May";
		String expDate = "12";
		selectFutureDate(driver, expYear, expMonth, expDate);

		// Close the driver
		driver.quit();
	}
}
