package checkboxes;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		URL myurl = new URL("https://testautomationpractice.blogspot.com/");
		driver.navigate().to(myurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

// Scenarion 1 Click single checkbox

		/*
		 * WebElement check =driver.findElement(By.
		 * xpath("//input[@class='form-check-input' and @value='sunday']"));
		 * System.out.println("Check box text="+check.getText()); check.click();
		 */

// Scenario 2 Check Multiple:
		/*
		 * List<WebElement> checkboxes=driver.findElements(By.
		 * xpath("//input[@class='form-check-input' and @type='checkbox']")); for(int
		 * i=0;i<checkboxes.size();i++) { checkboxes.get(i).click(); }
		 */
// Scenario 4 : selevct last 3 check boxes:
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for (int i = 3; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}

//Scenario 3 Check first 3

		/*
		 * List<WebElement> checkboxes=driver.findElements(By.
		 * xpath("//input[@class='form-check-input' and @type='checkbox']")); for(int
		 * i=0;i<(checkboxes.size()-4);i++) { checkboxes.get(i).click(); }
		 */
		Thread.sleep(5000);
// Scenario 4 unselect those which are selected     
		List<WebElement> checkboxess = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for (int j = 0; j < checkboxess.size(); j++) {
			if (checkboxess.get(j).isSelected()) {
				checkboxess.get(j).click();
			}
		}

		driver.close();

	}

}
