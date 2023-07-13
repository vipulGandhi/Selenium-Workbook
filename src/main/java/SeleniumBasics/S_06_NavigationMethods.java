package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class S_06_NavigationMethods
{
	public static void main(String[] args)
	{		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		// navigate() method functionality is exactly same as driver.get() method functionality
			// to() method internally calls driver.get() method only
		// driver.navigate().to("https://www.amazon.in/"); is same as driver.get("https://www.amazon.in/");
		// Open the new link in the same tab
		driver.navigate().to("https://www.amazon.in/");
		
		System.out.println(driver.getTitle());
		
		// Simulate browser back button
		driver.navigate().back();
		
		System.out.println(driver.getTitle());
		
		// Simulate browser forward button
		driver.navigate().forward();
		
		System.out.println(driver.getTitle());
		
		// Simulate browser refresh button
		driver.navigate().refresh();
		
		driver.quit();
	}
}
