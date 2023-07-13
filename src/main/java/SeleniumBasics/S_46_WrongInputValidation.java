// When we enter wrong input to any text field on the webpage some text or pop-up or alert is displayed
	// These text or pop-up or alert are not initially active on the webpage
	// They become active only when certain event gets triggered
	// Idea is to grab the locator of the updated element from the webpage and then proceed for the next steps


package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_46_WrongInputValidation
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://cloud.webscraper.io/login");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		By emailInputBox = By.id("username_id");
		By passwordInputBox = By.id("password_id");
		By signInButtonBy = By.xpath("//input[@value='SIGN IN']");
		
		By authenticationFailBy = By.xpath("//div[@class='alert alert-danger']");
		
		// Enter wrong credentials
		elementUtil.doSendKeys(emailInputBox, "email@gmail.commm");
		elementUtil.doSendKeys(passwordInputBox, "some password");
		elementUtil.doClick(signInButtonBy);
		
		if(elementUtil.isElementDisplayed(authenticationFailBy))
		{
			System.out.println("Invalid credentials ...");
		}
	}
}
