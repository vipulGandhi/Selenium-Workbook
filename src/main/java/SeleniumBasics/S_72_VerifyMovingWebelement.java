package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S_72_VerifyMovingWebelement
{
	public static void main(String[] args) throws InterruptedException
	{		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.html.am/html-codes/marquees/html-scrolling-text.cfm");
		
		driver.manage().window().maximize();
		
		WebElement movingElement = driver.findElement(By.xpath("//p[text()='Scroll left... ']"));
		
		Point currentPoint = movingElement.getLocation();
		
		System.out.println(currentPoint);
		
		Thread.sleep(2000);
		
		Point nextPoint = movingElement.getLocation();
		
		System.out.println(nextPoint);
	}
}
