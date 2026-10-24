package navigational;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switching {

	public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String url=driver.getCurrentUrl();
	System.out.println("The driver page url is="+url);
	String title=driver.getTitle();
	System.out.println("The driver page title is="+title);
	String windowId=driver.getWindowHandle();
	System.out.println("The parent window id is="+windowId);
	
	System.out.println("*************************************************");
	driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
	Set<String> windowIDs=driver.getWindowHandles();
	System.out.println("The windows IDs are="+windowIDs);
	
	for(String windowID:windowIDs)
	{
		driver.switchTo().window(windowID);
		System.out.println("window id=="+windowId);
		if(windowID.equals(windowId))
		{
			System.out.println("This is the parentpage");
			System.out.println("Parentpage id="+windowId);
			System.out.println("Parentpage title="+driver.getTitle());
			break; 
			
		}
		else
		{
			System.out.println("This is not a parentwindow");
		}
	}
    //driver.quit();
	}

}
