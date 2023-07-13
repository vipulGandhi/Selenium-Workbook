// Internally moves to the specified webelement
// Use Case:
	// This method replicates the scenario: Mouse over any menu item and the child items are displayed
		// Child items are displayed/ visible only when the user mouse-over the menu item 

// Task: Select "Company" -> "About Us" button
	// Hover on "Company" for the child menu to be displayed
	// Click on "About Us" button present in the child menu

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_30_ActionsClassMoveToElement
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.ActionsUtil actionsUtil = new GenericUtilities.ActionsUtil(driver);
		
		driver.get("https://www.orangehrm.com/");
		
		By contactsBy = By.xpath("//a[text()='Company']");
		By contactsAboutUsBy = By.xpath("(//a[text()='About Us'])[1]");
				
		// Only after the action is performed, the child elements are displayed on screen
		actionsUtil.doMoveToElement(contactsBy);
		
		Thread.sleep(3000);
		
		// Click on child element
		elementUtil.doClick(contactsAboutUsBy);
	}
}
