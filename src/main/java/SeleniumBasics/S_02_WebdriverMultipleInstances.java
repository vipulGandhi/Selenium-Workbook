// Why return type is List<WebElement>, not Set<WebElement> ?
	// List allows duplicates elements and if the passed locator is matched with duplicate elements also then it returns all.
    // List preserves the insertion order of elements which helps findElement() to internally calls findElements() and returns the first element


package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_02_WebdriverMultipleInstances 
{

	public static void main(String[] args)
	{
		
		// Creates 2 different sessions, launches 2 different browsers
		WebDriver driver_01 = new FirefoxDriver();
		WebDriver driver_02 = new FirefoxDriver();
		
		driver_01.get("https://www.google.com/");
		driver_02.get("https://www.google.com/imghp?hl=EN");
		
		
		By someBy = By.xpath(null);
		
		// WebElement is an interface
		// This call will do a freshness check to ensure that the element reference is still valid
			// This determines whether or not the element is still attached to the DOM
			// If this test fails, then a StaleElementReferenceException is thrown
		// This method is affected by implicit wait which is set for a WebDriver session
		// driver_01.findElement implicitly calls driver_01.findElements and return the element present in the 1st index
		// NoSuchElementException will be thrown only if no web element is found within the implicit timeout
		WebElement someElement = driver_01.findElement(someBy);
		
	}
}
