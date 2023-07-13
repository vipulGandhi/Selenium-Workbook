// Task: Search something on google -> A dropdown suggestion comes up -> Click on a specific suggestion 

// Start typing something in google search, a suggestion list comes up without page refresh - Ajax calls
// The suggestions appearing are called Ajax components
// The suggestions are coming from the server via the Ajax calls. Browser(DOM) does not maintain the suggestions
// To select any element from the suggestion list
	// Open Chrome DevTools
		// In the right section, select Event Listeners
			// In the event Listeners, Goto blur
				// Remove all the event listeners present inside blur

// Todo: Amazon Search


package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_16_SelectFromGoogleSearch
{

	String suggestionToBeSelectedString = "Persian cat";
	
	public static void main(String[] args) throws InterruptedException
	{
		S_16_SelectFromGoogleSearch s_16_SelectFromGoogleSearch = new S_16_SelectFromGoogleSearch();
		
		WebDriver driver = new FirefoxDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://www.google.com/");
		
		By searchBoxBy = By.name("q");
		elementUtil.doSendKeys(searchBoxBy, "Persia");
		
		Thread.sleep(5000);
		
		// Method 1: Get all suggestion webelements -> Select webelement whose text matches the string(Get the list -> Iterate over the list)
		//By allSuggestionsBy = By.xpath("//*[@class='mkHrUc']//*[@class='wM6W7d']");
		//elementUtil.printAllStringElements(elementUtil.getElementsText(allSuggestionsBy));
		//elementUtil.SelectWebelementFromList(elementUtil.getElements(allSuggestionsBy), "persian Cat");
		
		// Method 2 - Select the suggestion webelement by it's text - XPath Magic
		By suggestionTextBy = By.xpath("//*[@class='UUbT9']//div[@class='pcTkSc']//span[contains(text(),'"+s_16_SelectFromGoogleSearch.suggestionToBeSelectedString+"')]");
		elementUtil.doClick(suggestionTextBy);
	}
}
