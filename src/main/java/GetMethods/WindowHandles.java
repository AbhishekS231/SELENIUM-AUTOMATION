package GetMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws MalformedURLException {
       WebDriver driver= new ChromeDriver();
       driver.manage().window().maximize();
       URL myurl=new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.navigate().to(myurl);
       String windowID= driver.getWindowHandle();
       System.out.println(driver.getCurrentUrl());
       System.out.println(driver.getTitle());
       
      driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
      Set<String> windowIDs=driver.getWindowHandles();
      System.out.println("The multiple window ids are="+windowIDs);
       driver.quit();

	}

}
