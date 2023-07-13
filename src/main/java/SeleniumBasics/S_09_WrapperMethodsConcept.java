package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import GenericUtilities.BrowserUtil;
import GenericUtilities.ElementUtil;

public class S_09_WrapperMethodsConcept
{

	public static void main(String[] args)
	{
		BrowserUtil browserUtil = new BrowserUtil();
		WebDriver driver = browserUtil.launchBrowser("firefox");
		browserUtil.enterURL("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		String titleString = browserUtil.getPageTitle();
		System.out.println(titleString);
		
		GenericUtilities.ElementUtil elementUtil = new ElementUtil(driver);
		
		By firstnameBy = By.id("input-firstname"); 
		By lastnameBy = By.id("input-lastname");
		
		elementUtil.doSendKeys(firstnameBy, "User First Name");
		elementUtil.doSendKeys(lastnameBy, "User Last Name");
		
//		try
//		{
//			Thread.sleep(1000);
//		}
//		catch (InterruptedException e)
//		{
//			e.printStackTrace();
//		}
		
		browserUtil.closeBrowser();
	}
}
