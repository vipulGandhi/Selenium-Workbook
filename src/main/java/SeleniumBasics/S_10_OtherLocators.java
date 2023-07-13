package SeleniumBasics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class S_10_OtherLocators
{
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		
		// By name
		//By usernameBy = By.name("username");
		//By passwordBy = By.name("password");
		//elementUtil.doSendKeys(usernameBy, "Username");
		//elementUtil.doSendKeys(passwordBy, "password");
		
		// By Classname
		//By usernameBy = By.className("username");
		//By passwordBy = By.className("password");
		//elementUtil.doSendKeys(usernameBy, "Username");
		//elementUtil.doSendKeys(passwordBy, "password");
		
		// By XPath
			// Select the element from "Chrome Dev Tools" -> "Elements"
			// Right click -> Copy -> Copy XPath
		//By usernameBy = By.xpath("//*[@id=\"loginForm\"]/div/input[1]");
		//By passwordBy = By.xpath("//*[@id=\"loginForm\"]/div/input[2]");
		//elementUtil.doSendKeys(usernameBy, "Username");
		//elementUtil.doSendKeys(passwordBy, "password");
		
		// By CSS Selector
		// Select the element from "Chrome Dev Tools" -> "Elements"
		// Right click -> Copy -> Copy Selector
		//By usernameBy = By.cssSelector("#loginForm > div > input:nth-child(1)");
		//By passwordBy = By.cssSelector("#loginForm > div > input:nth-child(2)");
		//elementUtil.doSendKeys(usernameBy, "Username");
		//elementUtil.doSendKeys(passwordBy, "password");
		
		// By linktext [Only for links]
			// Get the link text displayed on the Web
		//String ContactUsLinkText = "Contact";
		//elementUtil.doClick("linktext", ContactUsLinkText);
		
		// By partialLinkText
			// Use where link text is long
		
		// By Tag name [1st example]
		// Print all link text in a webpage [For any link if there is no text attached, remove that text]
		//By allLinkTextBy = By.tagName("a");
		//elementUtil.printAllStringElements(elementUtil.getElementsText(allLinkTextBy));
		
		// By Tag name [2nd example]
		// There will be only one "h1" tag on a webpage [h1 = heading]
		//By webpageMainHeadingBy = By.tagName("h1");
		//System.out.println(elementUtil.getElementText(webpageMainHeadingBy));
		
		// By Tag name [3rd example][Get url attached to all links present on the webpage]
		//By allLinkTextBy = By.tagName("a");
		//elementUtil.printAllStringElements(elementUtil.getElementsAttributeValue(allLinkTextBy, "href"));
	}
}
