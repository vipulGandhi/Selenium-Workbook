// Locators
	// ID [ID is always unique inside HTML DOM][1st preference will always be given to id]
	// Name [Name can be duplicate][2nd preference to name]
	// Tag Name
		// Use Cases:
			// Find number of links on a webpage [<a> </a>]
			// Find number of images on a webpage [<img> </img>]
			// Find the number of frames on a webpage[<iFrame> </iFrame>] or [<frame> </frame>]
	// Class name [We can have same class name for different elements]
		// The value for class attribute may contains more than one class name 
		// [Eg. <input class="c1 c2 c3 c4">] --> Locator: By classBy = By.className("c1");
			// Only one class name is required
	// CSS
	// XPath
		// Every browser runs it's own XPath engine. The engines are efficient. XPath is not slower than CSS
			// The XPath index my differ on different browsers
		// Relative XPath [Recommended]
		// Absolute XPath
			// Start from root node [Not recommended]
	// Linktext
		// UI Text of the link
		// Linktext could be duplicate
		// HTML tag of link is always <a></a>
	// Partial link text

// On a webpage: Right click -> Click on "Inspect"
	// "Chrome Dev Tools" opens up which contains "Element", "Console", "Sources", "Network", "Performance" tabs etc.
		// "Element" tab displays DOM(Document Object Model) 
			// DOM is a XML document

// Sample
	// <input type="text" name="email" value="" placeholder="E-Mail Address" id="input-email" class="form-control">
		// Tag: input
		// Attribute: type
		// Value: text

// Use javascript executor or Robot class if we have to find the WebElement without locator


package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class S_08_LocatorConcept
{
	
	static WebDriver driver;
	
	public static void main(String[] args)
	{		
		driver = new FirefoxDriver();
		
		GenericUtilities.ElementUtil elementUtil =  new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		
		// 1st approach
			// Cons
				// Difficult to locate and change the web-element everywhere if it's locator changes
		//driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		// 2nd approach
			// Cons
				// Every time any method of "driver" is called (eg. "driver.findElement"), a request is sent to the server
				// WebElement is created every time, even if it is not needed
		//WebElement emailId = driver.findElement(By.id("input-email"));
		//WebElement password = driver.findElement(By.id("input-password"));		
		//emailId.sendKeys("test@gmail.com");
		//password.sendKeys("test@123");
		
		// 3rd approach
			// Pros
				// By.id does not create a WebElement, no request to server is sent
			// Cons
				// Not generic (calling driver.findElement() method again and again)
		//By emailBy = By.id("input-email");
		//By passwordBy = By.id("input-password");
		//driver.findElement(emailBy).sendKeys("email@gmail.com");
		//driver.findElement(passwordBy).sendKeys("password@123");
		
		// 4th approach
		// Pros
			// Generic, Have to write "driver.findElement" only once
		//By emailBy = By.id("input-email");
		//By passwordBy = By.id("input-password");
		//getElement(emailBy).sendKeys("test@gmail.com");
		//getElement(passwordBy).sendKeys("password@123");
		
		// 5th approach
		//By emailBy = By.id("input-email");
		//By passwordBy = By.id("input-password");
		//doSendKeys(emailBy, "test@gmail.com");
		//doSendKeys(passwordBy, "password@123");
		
		// 6th approach: Element util class with generic methods
		By emailBy = By.id("input-email");
		By passwordBy = By.id("input-password");
		elementUtil.doSendKeys(emailBy, "test@gmail.com");
		elementUtil.doSendKeys(passwordBy, "password@123");
		
		// 7th approach: String locator values
		//String emailId = "input-email";
		//String passwordId = "input-password";
		//elementUtil.doSendKeys("id", emailId, "test@gmail.com");
		//elementUtil.doSendKeys("id", passwordId, "password@123");
	}
	
	// Generic wrapper method
	public static WebElement getElement(By byLocator)
	{
		return driver.findElement(byLocator);
	}
	
	// Generic wrapper method
	public static void doSendKeys(By byLocator, String value)
	{
		getElement(byLocator).sendKeys(value);
	}
	
	// Generic wrapper method - Overload
	public static void doSendKeys(String locatorType, String locatorValue, String inputValue)
	{
		driver.findElement(getBy(locatorType, locatorValue)).sendKeys(inputValue);
	}
	
	// Generic wrapper method
	public static By getBy(String locatorType, String locatorValue)
	{
		By locator = null;
		
		switch (locatorType.toLowerCase())
		{
		case "id":
			locator = By.id(locatorValue);
			break;
		
		default:
			System.out.println("Please pass correct locator");
			break;
		}
		
		return locator;
	}
}
