// Verify if the element is displayed on the web page

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class S_11_ElementDisplayed
{

	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://www.google.com/");
		
		//By validSearchField = By.name("q");
		By InvalidSearchField = By.name("s");
		System.out.println(elementUtil.isElementDisplayed(InvalidSearchField));
	}
}
