// Verify if the element is present/ displayed on the webpage
	// elementUtil.isElementPresent(elementByLocator)
	// elementUtil.isElementDisplayed(elementByLocator)

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class S_12_NoSuchElementConcept
{
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://www.orangehrm.com/");
		
		// If the locator is incorrect or the locator is not present:
			// "driver.findElements(byLocator)" will throw no error and return 0
		// [For multiple elements] Verify if the "navigationLinkHeaders" are present on a webpage
		By navigationLinkHeadersBy = By.className("nav-link-hedd"); // Correct: By.className("nav-link-hed")
		if(elementUtil.isElementPresent(navigationLinkHeadersBy))
			System.out.println(elementUtil.getElementsCount(navigationLinkHeadersBy) + " navigationLinkHeaders are present in the webpage");
		else
			System.out.println("0 navigationLinkHeaders are present in the webpage");
		
		// If the locator is incorrect or the locator is not present:
			// "driver.findElement(byLocator)" will throw an error
				// Error [org.openqa.selenium.NoSuchElementException]
		//By platformLinkTextBy = By.linkText("Platformm"); //Correct: By.linkText("Platform")
		//String platformLinkText = elementUtil.getElementText(platformLinkTextBy);
		//System.out.println(platformLinkText);
		
		// [For single element] Verify if the "Platform" link is present on a webpage
		By platformLinkBy = By.linkText("Platformm");  //Correct: By.linkText("Platform")
		if(elementUtil.isElementDisplayed(platformLinkBy))
			System.out.println("platform link is present in the webpage");
		else
			System.out.println("platform link is not present in the webpage");
 	}
}
