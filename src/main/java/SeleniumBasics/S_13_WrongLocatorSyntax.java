package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_13_WrongLocatorSyntax
{
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		// If the locator is invalid
		// [Error] org.openqa.selenium.NoSuchElementException
		// In Selenium 3, it gives "Invalid Selector" exception [Which is right]
		By usernameBy = By.cssSelector("#orm_getForm_subdomain"); // Correct: By.cssSelector("#Form_getForm_subdomain")
		driver.findElement(usernameBy).sendKeys("Username");
	}
}
