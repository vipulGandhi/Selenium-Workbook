package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class S_17_ClickOnALinkFromSetOfLinks
{
	public static void main(String[] args) throws InterruptedException
	{	
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://www.linkedin.com/home"); 
				
		// All header link elements
		By allHeaderLinkElements = By.xpath("/html/body/nav//a");		
		elementUtil.SelectWebelementFromList(elementUtil.getElements(allHeaderLinkElements), "Discover");
	}
}
