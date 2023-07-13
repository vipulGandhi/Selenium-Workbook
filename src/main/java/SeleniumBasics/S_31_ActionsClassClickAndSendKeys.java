package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class S_31_ActionsClassClickAndSendKeys
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		
		GenericUtilities.ActionsUtil actionsUtil = new GenericUtilities.ActionsUtil(driver);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		By usernameBy = By.id("login1");
		By passwordBy = By.id("password");
		By signInBy = By.className("signinbtn");
		
		// This method is different from WebElement.sendKeys(CharSequence)
			// Equivalent to calling: Actions.click(element).sendKeys(keysToSend)
				// This method first click the element and then enter the CharSequence
		actionsUtil.doSendKeys(usernameBy, "My Username");
		actionsUtil.doSendKeys(passwordBy, "My Password");
		
		// This method is different from WebElement.click()
			// Clicks in the middle of the given element.
			// Equivalent to: Actions.moveToElement(onElement).click()
				// // This method first move to the element and then perform click()
		// The Webelement should be visible on the page
		actionsUtil.doClick(signInBy);
	}
}
