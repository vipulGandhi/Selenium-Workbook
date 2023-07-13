package SeleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_38_JavascriptAlertWait
{
	public static void main(String[] args)
	{
			WebDriver driver = new ChromeDriver();
			
			GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
			GenericUtilities.WaitUtils waitUtils = new GenericUtilities.WaitUtils(driver);
			
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			
			By signInButtonBy = By.xpath("//input[@value='Sign in']");
			elementUtil.doClick(signInButtonBy);
			
			// Selenium is expecting an alert to be present on the page
			// If alert is not present - [Exception] org.openqa.selenium.NoAlertPresentException
			// Alert may take time to load
			Alert currentAlert = waitUtils.isAlertPresent(5);
			System.out.println(currentAlert.getText());
			currentAlert.accept();			
	}
}
