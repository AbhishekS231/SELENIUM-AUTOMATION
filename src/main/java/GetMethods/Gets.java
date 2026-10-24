package GetMethods;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Gets {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		URL myurl=new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.navigate().to(myurl);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
	    String curURL=driver.getCurrentUrl();
	    System.out.println("The current page url is ="+curURL);
	    
	  
	    String title=driver.getTitle();
	    System.out.println("The current page title is ="+title);
		
		
	    String pageSource=driver.getPageSource();
	    System.out.println("The current pageSorce is ="+pageSource);
	    
		driver.close();
		

	}

}
