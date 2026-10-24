package testBase;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
	public WebDriver driver;
	public Logger logger; // Log4j Logger
	public Properties p;

	// BeforeClass annotation runs once before the start of the tests
	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {
		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources/config.properties");
		p = new Properties();
		p.load(file);

		// Initialize Logger
		logger = LogManager.getLogger(this.getClass());

		// Log system info
		logger.info("Operating System: " + os);
		logger.info("Browser: " + br);

		// Initializing the WebDriver based on the browser parameter
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			logger.error("Invalid browser name. Please provide a valid browser.");
			Assert.fail("Invalid browser: " + br);
			return;
		}

		logger.info("Browser setup completed successfully.");
		driver.get("https://dev.prosmarketplace.com/"); // Replace with actual URL
		logger.info("Navigating to: https://dev.prosmarketplace.com");

		// Maximize the browser window
		driver.manage().window().maximize();
        driver.get(p.getProperty(""));
		logger.info("*********** Setup Finished **********");
	}

	@AfterClass
	public void tearDown() {
		// Log the start of teardown
		logger.info("*********** TearDown Started **********");

		// Close the WebDriver instance after tests are complete
		if (driver != null) {
			driver.quit();
		}

		// Log completion of teardown
		logger.info("*********** TearDown Finished **********");
	}

	// Method to generate a random alphabetic string
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5); // Generate a string with 5 alphabetic
																		// characters
		return generatedString;
	}

	// Method to generate a random numeric string
	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10); // Generate a numeric string with 10 digits
		return generatedNumber;
	}

	// Method to generate a random alphanumeric string (combination of letters and
	// numbers)
	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(3); // Generate a string with 3 alphabetic
																		// characters
		String generatedNumber = RandomStringUtils.randomNumeric(3); // Generate a numeric string with 3 digits
		return generatedString + "@" + generatedNumber; // Combine alphabetic and numeric strings
	}

	// Method to capture screenshot
	public String captureScreen(String testName) {
		String screenPath = "./screenshots/" + testName + ".png"; // Define screenshot path
		try {
			// Capture screenshot using WebDriver's TakesScreenshot
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenPath);
			FileUtils.copyFile(srcFile, destFile); // Copy screenshot to the destination folder
			logger.info("Screenshot captured: " + screenPath); // Log success
		} catch (IOException e) {
			logger.error("Error while capturing screenshot: " + e.getMessage()); // Log error if screenshot fails
		}
		return screenPath; // Return the path of the screenshot
	}

	// Method to get current timestamp (useful for logging or unique test names)
	public String getCurrentTimestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		return sdf.format(new Date());
	}
}
