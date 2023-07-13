// Browser window pop-up/ New Tab window/ New Browser Window

package SeleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_53_GetWindowHandle
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Parent window opens up
		
		System.out.println(driver.getCurrentUrl());
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);

		Thread.sleep(5000);
		
		By twitterLinkBy = By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']");
		
		elementUtil.doClick(twitterLinkBy);
		// Child window opens up
		
		// Now, 2 windows are present on the browser
			// Both windows are associated with same driver
			// Currently, driver is on parent window
		
		// Collect all window id's
			// Every browser window has it's own unique id
			// Window id's are always dynamic
				// With next execution, we will get new window id's
		// Set
			// Does not take any duplicate value
			// Does not maintain any index for it's values
		// A Set object will be created
			// First object in the set will always be parent window id
			// All the child windows be in random order next
		// allWindowHandleSet is referring to the Set object
		Set<String> allWindowHandleIdsSet =  driver.getWindowHandles();
		
		// Iterator is used to fetch the data from those collections which does not maintain any order
			// We use iterators on Set because it does not maintain any index for it's values
			// for loop can't work on set
		Iterator<String> handleIterator = allWindowHandleIdsSet.iterator();
		
		// handleIterator initially does not point to any object in the set
			// It only points to the object when "handleIterator.next();" is called
		// If the first/ next object is present in the Set
		String parentWindowHandleIDString =  handleIterator.next();
		System.out.println(parentWindowHandleIDString);
		
		String childWindowHandleIDString =  handleIterator.next();
		System.out.println(childWindowHandleIDString);
		
		// Currently the driver is available on the parent window
		// Switch driver to child window
		driver.switchTo().window(childWindowHandleIDString);
		System.out.println(driver.getCurrentUrl());
		
		// Close child window
		driver.close();
		// driver is lost now
		
		// Attach the driver to parent window again
		driver.switchTo().window(parentWindowHandleIDString);
		System.out.println(driver.getCurrentUrl());
		
//		while (handleIterator.hasNext())
//		{
//			// Move the pointer to first/ next object
//			String windowHandleIDString =  handleIterator.next();
//			System.out.println(windowHandleIDString);
//		}
	}
}
