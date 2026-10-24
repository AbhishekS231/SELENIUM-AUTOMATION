package uploadfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='filesToUpload']"))
				.sendKeys("C:\\Users\\Abhishek Sharma\\Desktop\\User.scv.xlsx");
		if (driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("User.scv.xlsx")) {
			System.out.println("Upload file successfull");

		} else {
			System.out.println("Upload file Fail");
		}

	}

}
