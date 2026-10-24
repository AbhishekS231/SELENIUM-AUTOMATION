package tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTablePagination {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement table = driver.findElement(By.xpath("//table[@id='productTable']"));
		// Execute JavaScript to scroll the element into view
		js.executeScript("arguments[0].scrollIntoView(true);", table);

		int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		System.out.println("Totola Number Of rows::" + rows);
		int clmn = driver.findElements(By.xpath("//table[@id='productTable']//thead//tr//th")).size();
		System.out.println("Totola Number Of column::" + clmn);

		for (int page = 1; page <= 4; page++) {
			if (page > 1) {
				driver.findElement(By.xpath("//a[@class='active'][normalize-space()='"+page+"']")).click();
			}

			for (int i = 1; i <= rows; i++) {
				for (int j = 1; j <= clmn; j++) {
					String tableData = driver
							.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + i + "]//td[" + j + "]"))
							.getText();
					System.out.print(tableData + "    ");
				}
				System.out.println();
			}
		}

	}

}
