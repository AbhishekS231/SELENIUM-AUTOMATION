package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
//Css Selector Locators	 TagName#IdValue
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
		
//Css selector by Class Name  tagname.classname
		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("MacBook");
		
// Css Selector By Attribute	
		//driver.findElement(By.cssSelector("input[name='q']")).sendKeys("MacBook");
		
		
//Css Selector By TagName.ClassValue	attribute	
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("MacBook");
	String srchText	=driver.findElement(By.xpath("//button[text()='Search']")).getText();
	System.out.println("The search box text is ="+srchText);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		driver.close();
		
	}

}
