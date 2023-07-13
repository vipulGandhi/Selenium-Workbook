// Lets do some monkey testing on amazon footer links

package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_59_MonkeyTesting
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);

		
		// Get all the links in amazon footer section
		By allFooterLinks = By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//a");
		
		List<WebElement> allElementsFooterLinksElements = elementUtil.getElements(allFooterLinks);
		
		int footerLinkCount = elementUtil.getElementsCount(allElementsFooterLinksElements);
		
		System.out.println("Footer count " + footerLinkCount);
		
		for (int i = 0; i < footerLinkCount; i++)
		{
			int randomNumber = (int)Math.floor(Math.random() * footerLinkCount);
			
			WebElement webElement = allElementsFooterLinksElements.get(randomNumber);
			
			System.out.println(webElement.getText());
			
			webElement.click();
			
			driver.navigate().back();
			
			Thread.sleep(1500);
			
			// Update the list to avoid StaleElementException
			allElementsFooterLinksElements = elementUtil.getElements(allFooterLinks);
		}
	}
}
