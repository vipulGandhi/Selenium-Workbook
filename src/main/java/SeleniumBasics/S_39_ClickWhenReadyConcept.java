// The element is already present on the page but need some time or event to complete before becoming clickable

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_39_ClickWhenReadyConcept
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.WaitUtils waitUtils = new GenericUtilities.WaitUtils(driver);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By registerButtonBy = By.xpath("//a[text()='Register' and @class='list-group-item']");
		elementUtil.doClick(waitUtils.ifElementVisibleAndClickable(registerButtonBy, 5));
	}
}
