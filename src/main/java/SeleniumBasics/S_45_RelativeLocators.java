// Task: Get the group of a given company name

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_45_RelativeLocators
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupall");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		By companyNameBy = By.partialLinkText("Deccan Gold Mines");
		By companyGroupBy = By.tagName("td");
	
		// Relative Locator
		// Relative locators are relatively slow as the By locator of the element to get is very generic
			// Selenium takes lot of time to search for the element
		// Use Cases
			// Can be used in Web table handling
		System.out.println(elementUtil.getElementText(elementUtil.getWebElementToTheRightOf(companyGroupBy, companyNameBy)));
	}
}
