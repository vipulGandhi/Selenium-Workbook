// XPath Syntax
	// "//" is used for far associates, "/" is used for next associate
	// Every attribute starts with @
	// //Tag[@attribute='value']
	// //Tag[@attribute01='value' and @attribute02='value']
	// //Tag[@attribute01='value' or @attribute02='value']
	// //Tag[text()='value'] //For links and for all other text fields
	// //Tag[contains(@attribute,'value')]
	// //Tag[contains(@attribute,'partialAttributeText')] // For webelements where part of attribute value changes after every page refresh
		// Example:For a webelement <input id = test_123>
		//							<input id = test_456> [Page refresh]
		// XPath: //input[contains(@id,'test_')]
	// //Tag[contains(text(),'value')]
	// //Tag[contains(text(),'partialText')] // For webelements where part of text changes after every page refresh
	// //Tag[contains(@attribute01,'value') or @attribute02='value'] (Either the 1st xpath or the 2nd xpath)
	// //Tag[contains(@attribute01,'value') and contains(@attribute02,'value')]
	// //Tag[contains(@attribute01,'value') and contains(text(),'value')]
	// //Tag[contains(@attribute01,'value') and contains(@attribute02,'value') and contains(@attribute03,'value')]
	// //Tag[starts-with(@attribute,'value')] // For webelements where part of attribute value changes after every page refresh
	// XPath with class names
		// [Eg. <input class="c1 c2 c3 c4">] --> Locator: By xPathBy = By.xpath("c1 c2 c3 c4");
			// All class names are required
	// XPath with index
		// Examples:
			// (//Tag[@attribute='value'])[4]//a   		 // Get all links from this particular division tag
			// ((//Tag[@attribute='value'])[4]//a)[3]    // Get 4th link from this particular division tag
			// (//Tag[@attribute='value'])[last()]       // Go to the last element
	// //div[text()=’Vipul Gandhi’]//following-sibling::a
	// //div[text()=’Vipul Gandhi’]//preceding-sibling::a
	// //div[text()!=’Vipul Gandhi’]//preceding-sibling::a
	// //div[text()=>10]//preceding-sibling::a
	// HTML DOM ewbelement with uneven whitespace
		// <a id=" someAnchor " class="mce-item-anchor"> Text    with    uneven    whitespaces   </a>
		// Xpath: //a[normalize-space(text())=’Text with uneven whitespaces’]



package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_19_XPath
{
	public static void main(String[] args)
	{	
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.orangehrm.com/"); 
		
		// Get 2nd link from 2nd division tag from footer section
		By linkInFooterDivisionBy = By.xpath("((//div[@class='col-sm-6 col-md-3'])[2]//a)[2]");
		System.out.println(driver.findElement(linkInFooterDivisionBy).getText());
	}
}
