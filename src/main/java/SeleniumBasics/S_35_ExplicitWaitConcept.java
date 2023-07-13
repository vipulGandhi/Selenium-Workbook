// Explicit wait is a concept
	// WebdriverWait and FluentWait both are explicit wait
// It is dynamic in nature
// Not a global wait
	// It can be applied to a specific webelement or non web elements (alert, url, page title)
// WebdriverWait: Default polling time 500 ms
	// If the wait is of 10 seconds, after every 500 ms, selenium poll the application for element presence


package SeleniumBasics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_35_ExplicitWaitConcept
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.WaitUtils waitUtils = new GenericUtilities.WaitUtils(driver);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		By usernameBy = By.xpath("//input[@id='login1']");
		By passwordBy = By.id("password");
		By signInBy = By.xpath("//input[@title='Sign in']");
		
		By topHeadlinesBy = By.xpath("//div[@id='top_news_container']//a");

		elementUtil.doSendKeys(waitUtils.isPresenceOfElementLocated(usernameBy, 10), "User name");
		elementUtil.doSendKeys(waitUtils.isPresenceOfElementLocated(passwordBy, 8, 1000), "Password");
		elementUtil.doClick(waitUtils.isPresenceOfElementLocated(signInBy, 0));
		
		System.out.println(elementUtil.getElementsCount(waitUtils.isVisibilityOfElementsLocated(topHeadlinesBy, 10)));
	}
}
