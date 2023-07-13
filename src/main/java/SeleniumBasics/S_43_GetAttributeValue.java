package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_43_GetAttributeValue
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		By userNameBy = By.id("login1");
		
		elementUtil.doSendKeys(userNameBy, "user name");
		
		System.out.println(elementUtil.getElementAttributeValue(userNameBy, "value"));
	}
}
