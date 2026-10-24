package mouseractions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html#google_vignette");
		driver.manage().window().maximize();
		WebElement source=driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement destination= driver.findElement(By.xpath("//div[@id='box106']"));
		Actions act= new Actions(driver);
		act.dragAndDrop(source, destination).perform();
		

	}

}
