// CSS Selector Syntax
	// #id
	// Tag#id
	// .className
	// Tag.className
	// #id.className
	// Tag#id.className
	// .className#id
	// Tag.className#id
	// With class names
		// [Eg. <input class="c1 c2 c3 c4">] --> Locator: By cssSelectorBy = By.cssSelector(c1.c2.c3.c4)
		// [Eg. <input class="c1 c2 c3 c4">] --> Locator: By cssSelectorBy = By.cssSelector(input.c1.c2.c3.c4)
		// [Eg. <input id='ID' class="c1 c2 c3 c4">] --> Locator: By cssSelectorBy = By.cssSelector(.c1.c2.c3.c4#ID)
		// [Eg. <input id='ID' class="c1 c2 c3 c4">] --> Locator: By cssSelectorBy = By.cssSelector(input.c1.c2.c3.c4#ID)
		// [Eg. <input id='ID' class="c1 c2 c3 c4">] --> Locator: By cssSelectorBy = By.cssSelector(#ID.c1.c2.c3.c4)
		// [Eg. <input id='ID' class="c1 c2 c3 c4">] --> Locator: By cssSelectorBy = By.cssSelector(input#ID.c1.c2.c3.c4)
		// All class names are required
	// If id and class attributes are not available
		// Tag[attribute='value']
		// Tag[attribute01='value'][attribute02='value']
	// Contains() method in CSS Selector
		// Tag[attribute*='value']
	// Parent - Child traversal
		// ParentCssSelector Space ChildCssSelector
			// Get all direct and indirect child elements
		// ParentCssSelector > ChildCssSelector
			// Get all direct child elements
	// Child - parent traversal : Not allowed
		// Backward traversing in CSS is not allowed
			// Not possible to automate dynamic webtable scenarios where child -> parent traversing is necessary
	// Preceding Sibling Concept : Not allowed
	// Following Sibling concept
		// SiblingCssSelector+NextSiblingTag
	// Comma in CSS - Not in XPath
		// To get a list of different webElements of different types
			// CSSSelector01, CSSSelector02, CSSSelector03, CSSSelector04, CSSSelector05
	// Indexing is possible


package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_25_CustomCSSSelector
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://app.hubspot.com/login"); 
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		// Get all div inside login form
		By allDiv = By.cssSelector("#hs-login div");
		System.out.println(elementUtil.getElementsCount(allDiv));
		
		// Get all the form input fields
		By allInputFieldsBy = By.cssSelector("#username, #password");
		System.out.println(elementUtil.getElementsCount(allInputFieldsBy));
	}
}
