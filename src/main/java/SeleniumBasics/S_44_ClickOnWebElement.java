// Different methods to perform click on the web element

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.WaitUtils;

public class S_44_ClickOnWebElement
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.rediff.com/");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.ActionsUtil actionsUtil = new GenericUtilities.ActionsUtil(driver);
		GenericUtilities.JavascriptUtil javascriptUtil = new GenericUtilities.JavascriptUtil(driver);
		GenericUtilities.WaitUtils waitUtils = new WaitUtils(driver);
		
		By signInLinkBy = By.xpath("//a[text()='Sign in']");
		By homePageLinkBy = By.xpath("//a[text()='rediff.com']");
		
		// Driver - Click
		elementUtil.doClick(signInLinkBy);
		
		Thread.sleep(2000);
		
		// Actions - Click
		actionsUtil.doClick(homePageLinkBy);
		
		Thread.sleep(2000);
		
		// Actions - Then MoveToElement - Then Click
		actionsUtil.doMoveToElement(signInLinkBy);
		actionsUtil.doClick(signInLinkBy);
		
		// Javascript - Click
		javascriptUtil.doClick(elementUtil.getElement(homePageLinkBy));
		
		// Wait for element - Click
		waitUtils.ifElementVisibleAndClickable(signInLinkBy, 2);
		elementUtil.doClick(signInLinkBy);
	}
}
