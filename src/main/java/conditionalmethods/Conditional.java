package conditionalmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conditional {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean enable=driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).isEnabled();
		System.out.println("The text field status is enable="+enable);
		boolean display=driver.findElement(By.xpath("//a[@class='wikipedia-search-wiki-link']")).isDisplayed();
		System.out.println("The image status is display="+enable);
		boolean selected= driver.findElement(By.xpath("//label[text()='Male' and @class='form-check-label']")).isSelected();
		System.out.println("The check box status is selected="+selected);
		//driver.close();
		
	}

}
