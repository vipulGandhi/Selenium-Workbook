package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


// Wrapper Class
public class BrowserUtil
{
	// The driver should not be static
		// https://qualitytimes.tech/should-not-use-static-webdriver/
		// https://www.freecodecamp.org/news/a-quick-intro-to-dependency-injection-what-it-is-and-when-to-use-it-7578c84fa88f/
	public WebDriver driver;
	
	// This method is used to launch the browser on the basis of browser name
	// Cross browser testing logic
	public WebDriver launchBrowser(String browser)
	{
		
		if(browser.trim().equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();	
		}
		else if (browser.trim().equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browser.trim().equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}
		else
		{
			System.out.println("Please pass correct browser name");
		}
		
		return driver;
	}
	
	// This method is used to enter the url
	public void enterURL(String url)
	{
		
		if(url == null)
		{
			System.out.println("Null url pssed");
			return;
		}
		
		if(!url.contains("http"))
		{
			System.out.println("http is missing in url");
			return;
		}
		
		driver.get(url);
	}
	
	// This method will return the current page url
	public String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}
	
	// This method will return the current page title
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	// This method will close the browser
	public void closeBrowser()
	{
		driver.close();
	}
	
	// This method will quit the browser
	public void quitBrowser()
	{
		driver.quit();
	}
	
}
