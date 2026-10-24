package navigational;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

	public static void main(String[] args) throws MalformedURLException {
		 WebDriver driver= new ChromeDriver();
	       driver.manage().window().maximize();
	       URL myurl=new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	       driver.navigate().to(myurl);
	      
	       driver.navigate().refresh();
	
	       driver.get("https://demo.nopcommerce.com/");
	       driver.navigate().refresh();
	       driver.navigate().back();
	       System.out.println("The orange hrm get methods are");
	       System.out.println(driver.getCurrentUrl());
	       System.out.println(driver.getTitle());
	       driver.navigate().forward();
	       System.out.println("***************************************************");
	   	
	       System.out.println("Thenopcommerece get methods are");
	       System.out.println(driver.getCurrentUrl());
	       System.out.println(driver.getTitle());
	       driver.close();
	       

	}

}
