// Only CSSSelector and Javascript executor works with Shadow DOM Element
// XPath does not work with Shadow DOM elements
// Shadow DOM elements comes under #shadow-root (open) section in DOM
// Shadow section has it's own DOM structure
// Access the Shadow DOM elements with Javascript executor
	// Convert the driver to Javascript executor to access the Shadow DOM element
	// Select Shadow DOM web element in Chrome Developer Tool
		// Right click -> Copy -> Copy JS Path
			// Go to console in Chrome Developer Tool -> Enter the path -> Enter

// In this particular website, Shadow DOM is the child of an iFrame
	// Web Hierarchy:
		// Browser -> Page -> iFrame -> Shadow DOM -> element


package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_51_ShadowDOMElement
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.JavascriptUtil javascriptUtil = new GenericUtilities.JavascriptUtil(driver);
		
		driver.switchTo().frame("pact");
		
		String teaInputBoxString = "document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")";
		
		WebElement webElement = javascriptUtil.executeJavaScript(teaInputBoxString);
		
		elementUtil.doSendKeys(webElement, "I Love Chai !!");
	}
}
