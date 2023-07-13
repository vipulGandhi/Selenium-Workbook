package GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtil
{
	private WebDriver driver;
	
	
	public JavascriptUtil(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement executeJavaScript(String javaScriptString)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		
		// Convert the javascript object to WebElement 
		 WebElement webElement = (WebElement) jsExecutor.executeScript("return " + javaScriptString);
		 return webElement;
	}
	
	/** Get Page Title */
	public String getTitle()
	{
		// Convert the driver to JavascriptExecutor
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		return jsExecutor.executeScript("return document.title;").toString();
	}
	
	// Use case:
		// 1. During code debugging
		// 2. During code Demo
	public void generateAlert(String message)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("alert('"+ message +"')");
	}
	
	// Get the text present on the entire page.
	// Use Cases
		// Content testing
		// Verify any important text present in the page
	// Different from "driver.getPageSource()" which returns the page javascript code
	public String getpageInnerText()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		return jsExecutor.executeScript("return document.documentElement.innerText;").toString();
	}
	
	public void refreshPage()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("history.go(0)");
	}
	
	// Highlight/ continuously blink the webelement
	// Use Cases
		// Let us know where exactly the driver control is
			// First highlight the webelement
			// Then perform the driver operation
		// Code debugging
	
	public void flashWebElement(WebElement webElement)
	{
		String bgcolor = webElement.getCssValue("backgroundColor");
		for (int i = 0; i < 5; i++)
		{
			changeColor("rgb(255,192,203)", webElement);
			changeColor(bgcolor, webElement);
		}
	}
	
	private void changeColor(String color, WebElement webElement)
	{
		JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
		jsExecutor.executeScript("arguments[0].style.backgroundColor=' " + color + " ' ",webElement);
		try
		{
			Thread.sleep(400);
		}
		catch (InterruptedException e)
		{
		}
	}
	
	// driver.findElement(By).click()
		// The methods perform the action on the webpage
	// JavascriptExecutor click() method performs the action inside the DOM
		// It performs the click even if the element is not visible/ available on the webpage
	// Not recommended
		// If driver.click() or Actions.click() is not working then only use JavascriptExecutor.click()
			// If the webelement is overlapped by some other webelement
				// ElementNotInteractableException
					// 1. Try using Actions.click()
					// 2. Try using JavascriptExecutor.click()
	public void doClick(WebElement webElement)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", webElement);
	}
	
	// Not recommended
	public void sendKeysWithElementld(String id, String value)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("document.getElementByld('" + id + "').value='" + value + "'");
	}
	
	public void scrollToBottom()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	// Horizontal or Vertical scroll till the webelement is found
	public void scrollToWebElement(WebElement webElement)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}
	
	// Scroll Down: Enter any positive number as the argument
	// Scroll Up: Enter any negative number as the argument
	public void scrollByPixel(String numberOfPixelsToScrollTo)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,'"+ numberOfPixelsToScrollTo + "')");
	}
	
	public void scrollToUp()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	// Use Case
		// Can be used to visually locate a specific Webelement
		// Create the border on the buggy webelement and then take screenshot for reporting
	public void drawBorder(WebElement webElement)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='3px solid red'", webElement);
	}
	
	// After switch to a different url - wait for the page to be loaded completely
	// Wait time - 20 seconds
	public void waitForPageLoaded()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String loadingStatus = jsExecutor.executeScript("return document.readyState;").toString();
		if (loadingStatus.equals("complete"))
		{
			System.out.println("page is fully loaded");
		}
		else
		{
			for (int i = 1; i <= 20; i++)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				loadingStatus = jsExecutor.executeScript("return document.readyState;").toString();
				System.out.println("current page loading status: " + loadingStatus);
				if (loadingStatus.equals("complete"))
				{
					break;
				}
			}
		}
	}
}
