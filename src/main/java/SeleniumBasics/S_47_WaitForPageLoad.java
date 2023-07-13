package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_47_WaitForPageLoad
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://api.cogmento.com/register/");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.JavascriptUtil javascriptUtil = new GenericUtilities.JavascriptUtil(driver);
		
		By logInHereLinkBy = By.partialLinkText("Log in here");
		By emailInputBy = By.xpath("//input[@placeholder='E-mail address']");
		
		elementUtil.doClick(logInHereLinkBy);
		
		// Wait for next page to be loaded completely
		javascriptUtil.waitForPageLoaded();
		
		elementUtil.doSendKeys(emailInputBy, "username");
	}
}