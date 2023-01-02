package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S_17_ClickOnALinkFromSetOfLinks
{
	public static void main(String[] args) throws InterruptedException
	{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://www.linkedin.com/home"); 
				
		// All footer link elements
		By allFooterLinkElements = By.xpath("/html/body/nav//a");		
		elementUtil.SelectWebelementFromList(elementUtil.getElements(allFooterLinkElements), "Discover");
	}
}
