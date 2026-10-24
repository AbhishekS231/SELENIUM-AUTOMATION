package brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
// Step 1 return all links:
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		int noOfBrokenlink = 0;
// step 2 links should not be null and empty
		for (WebElement linkElement : links) {
			String hrefAttValue = linkElement.getAttribute("href");
			if (hrefAttValue == null || hrefAttValue.isEmpty()) {
				System.out.println("Not Posible to chekc because the link is empty");
				continue;
			}
			try {
				URL linkURL = new URL(hrefAttValue);
				HttpURLConnection connectURL = (HttpURLConnection) linkURL.openConnection();
				connectURL.connect();
//Step 3 get response
				if (connectURL.getResponseCode() >= 400) {
					System.out.println("Links are broken" + " " + hrefAttValue);
					noOfBrokenlink++;

				}
			} catch (Exception e) {

			}

		}
		System.out.println("noOfBroken links are" + " " + noOfBrokenlink);
	}

}
