package uploadfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFiles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		String file1 = "C:\\Users\\Abhishek Sharma\\Desktop\\User.scv.xlsx";
		String file2 = "C:\\Users\\Abhishek Sharma\\Desktop\\Jmeter Parameterization File.CSV";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);
		if (driver.findElements(By.xpath("//ul[@id='fileList']//li")).size() == 2) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
//File Name Matching
		if (driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("User.scv.xlsx")) {
			System.out.println("Upload file successfull");

		} else {
			System.out.println("Upload file Fail");
		}

		
	}

}
