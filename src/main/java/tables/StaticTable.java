package tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement table = driver.findElement(By.xpath("//table[@name='BookTable']"));
		// Execute JavaScript to scroll the element into view
		js.executeScript("arguments[0].scrollIntoView(true);", table);
//rows:Table
		int row = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Total Number Of rows::" + row);

//column:Table
		int clmn = driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
		System.out.println("Total Number Of rows::" + clmn);

//Read The Data from The Table:
		for (int i = 2; i <= row; i++) {
			for (int j = 1; j <= clmn; j++) {

				String tableData = driver
						.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[" + j + "]")).getText();
				System.out.print(tableData + "    ");
			}
			System.out.println();
		}
System.out.println("****************************************************************************************");
// Read The data :AutherName:Mukesh
		for (int i = 2; i <= row; i++) {

			String autherName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[2]"))
					.getText();
			if(autherName.equals("Mukesh"))
			{
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[1]"))
						.getText();
				System.out.println(bookName);
			}

		}

		 driver.close();
	}

}
