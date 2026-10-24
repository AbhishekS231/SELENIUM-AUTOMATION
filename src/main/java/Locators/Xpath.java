package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
//X-Path By using single aatribute
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Macbook");
       
		
//Xpath using and or operators and Multi attribute
		/*driver.findElement(By.xpath("//input[@name='q'and @id='small-searchterms']")).sendKeys("Macbook");
		driver.findElement(By.xpath("//input[@name='q'or @id='small-searchterms']")).sendKeys("Macbook");*/
		
		
		//driver.findElement(By.xpath("//input[@name='q'][@id='small-searchterms']")).sendKeys("Macbook");
		//driver.findElement(By.xpath("//a[text()='Computers '][1]")).click();

//Xpath with inner text ot text()function
		//boolean disStatus=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
		//System.out.println("The status is="+disStatus);
		//String text=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
		//System.out.println("The text is="+text);
		
//Xpath with contains
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Search store')]")).sendKeys("Macbook");
//Xath with starts-with		
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search store')]")).sendKeys("Macbook");
		
//chainned Xpath
		/*boolean status=driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).isDisplayed();
		System.out.println("the status is="+status);*/
		driver.close();
	}
 
}
