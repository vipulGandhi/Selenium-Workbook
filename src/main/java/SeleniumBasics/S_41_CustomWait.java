// Task: Create your own waiting mechanism

// Task 1.1: Which loop to use
	// Because we do not know for how much time we have to wait for webelement - we have to keep polling
		// Number of polling request are not known beforehand - Number of iterations are not known
			// Use While loop instead of for loop
		
// Task 1.2: Which wait mechanism to use
	// All wait class are using Thread.Sleep() internally
		// We will also use Thread.sleep()

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_41_CustomWait
{
	
	public static void main(String[] args)
	{		
		WebDriver driver = new ChromeDriver();
		
		GenericUtilities.WaitUtils waitUtils = new GenericUtilities.WaitUtils(driver);
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		// Positive scenario
		By emailIdBy = By.id("input-email");
		
		// Negative scenario
		//By emailIdBy = By.id("input-email11");
		
		waitUtils.customWait(emailIdBy, 10, 500l).sendKeys("user name");
	}
}
