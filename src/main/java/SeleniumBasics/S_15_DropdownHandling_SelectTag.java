// "Select" HTML tag for dropdown 
// Use "Select" class in Selenium
	// Works only when dropdown HTML tag is "Select"
// Select class can also have multi select dropdown
	// It provides a method named isMultiple() which returns a boolean
    	// If drop-down is multi select, isMultiple() will return true otherwise false
// Select class provides a method named getOptions() to get all available options in a drop-down
	// Return type of getOptions() method is a List<WebElement>
// Get all selected options in a multi select drop-down
	// Select class provides a method named getAllSelectedOptions() which returns a List<WebElement>
// Deselect all values from a multi select drop-down
	// Select class provides a method named deselectAll() which will deselect all selected options
		// This method is only for multi select dropdown

package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class S_15_DropdownHandling_SelectTag
{
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		// Parent locator
		By countryDropdownBy = By.id("Form_getForm_Country");
		
		// XPath to reach all child elements from parent element
		By countryDropdownChildElementsFromParentBy = By.xpath("//select[@id='Form_getForm_Country']/option");
		
		elementUtil.doDropdownSelectByIndex(countryDropdownBy, 1);
		elementUtil.doDropdownSelectByValue(countryDropdownBy, "India");
		elementUtil.doDropdownSelectByVisibleText(countryDropdownBy, "Australia");
		
		// Get the count of all WebElements in Select dropdown
		System.out.println(elementUtil.getAllSelectDropdownElementsCount(countryDropdownBy));
		
		// Verify if Japan is present in dropdown
		System.out.println(elementUtil.isElementTextPresentInSelectDropdown(countryDropdownBy, "Japan"));
		
		// Select the dropdown element without select class
			// Get all the child elements of parent web element
		List<WebElement> allDropdownElements = elementUtil.getElements(countryDropdownChildElementsFromParentBy);
		
		for (WebElement webElement : allDropdownElements)
		{
			if(webElement.getText().equals("Brazil"))
			{
				webElement.click();
				break;
			}
		}
	}
}
