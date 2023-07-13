// Why do we get stale element exception
	// Create a WebElement
	// Use the same element after refreshing the page/ Back Forward simulation

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_55_StaleElementException
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		// The url gives a DOM to the browser
		driver.get("https://demo.opencart.com/index.php?route=account/login");
						
		// Create a WebElement
		WebElement emailInputElement = driver.findElement(By.id("input-email"));
		
		// Use the element
		emailInputElement.sendKeys("email@gmail.com");
		
		// Refresh the page
			// The DOM will be loaded again (this is the new DOM)
		driver.navigate().refresh();
		
		// Use the element again
		// Driver is still accessing old DOM element
		// Error [org.openqa.selenium.StaleElementReferenceException]
			// element is not attached to the current DOM
		//emailInputElement.sendKeys("email@gmail.com");
						
		// Solution - 01
			// Reinitialize the element for the new DOM
		WebElement emailInputElement_01 = driver.findElement(By.id("input-email"));
		
		// Use the element
		emailInputElement_01.sendKeys("newemail@gmail.com");
		
		// Solution - 02
			// Use fluent wait OR WebDriver wait with the condition: "ignoring(StaleElementReferenceException.class)"
				// If selenium gets the above exception during wait
					// It will ignore the exception
					// It will assign the element from new DOM to the driver
					// No need to reinitialize the webelement again
		
		// Solution - 03
			// Use By class strategy and use "driver.findElement(byLocator)" at the runtime.
				// By class doesn't gives the stale element as it maintains only the locator
	}
}
