package ddt;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

		String filePath = System.getProperty("user.dir") + "\\TestData\\Calculator.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

		for (int i = 1; i <= rows; i++) {
			// Read data from Excel
			String principal = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String interestRate = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String tenure = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String tenurePeriod = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String frequency = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String expectedMaturityValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

			// Scroll to the element
			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='gB_20']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			// Clear and enter new data into the application
			WebElement principalField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("principal")));
			principalField.clear();
			principalField.sendKeys(principal);

			WebElement interestField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest")));
			interestField.clear();
			interestField.sendKeys(interestRate);

			WebElement tenureField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tenure")));
			tenureField.clear();
			tenureField.sendKeys(tenure);

			Select tenureDropdown = new Select(driver.findElement(By.id("tenurePeriod")));
			tenureDropdown.selectByVisibleText(tenurePeriod);

			Select frequencyDropdown = new Select(driver.findElement(By.id("frequency")));
			frequencyDropdown.selectByVisibleText(frequency);

			WebElement calculateButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")));
			calculateButton.click();

			// Fetch the actual maturity value
			WebElement maturityValueElement = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='resp_matval']//strong")));
			String actualMaturityValue = maturityValueElement.getText();

			// Compare the expected and actual values
			if (Double.parseDouble(expectedMaturityValue) == Double.parseDouble(actualMaturityValue)) {
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
			} else {
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
			}

			// Navigate back to the calculator
			WebElement backButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='PL5']")));
			backButton.click();
		}

		// Close the browser
		driver.quit();
	}

}
