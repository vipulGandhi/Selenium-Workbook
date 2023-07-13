package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S_67_FileUpload
{
	public static void main(String[] args) throws InterruptedException
	{		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get("https://www.foundit.in/seeker/registration");
		 
		// Select the input tag element where type="file"
		WebElement cvUploadWebElement = driver.findElement(By.xpath("//input[@id='file-upload']"));

		//Uploading the file using sendKeys
		cvUploadWebElement.sendKeys(System.getProperty("user.dir") +  "/LocalResourceFiles/SampleFiles/sample.pdf"); 
	}
}
