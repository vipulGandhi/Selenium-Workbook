// The browser only understand javascript
// A few web operations which can not be done with selenium, can be done with JSExecutor
// Use cases
	// Scroll up/ down
	// Creation of alerts
	// Getting the text of entire page
	// Click on Webelement

// To perform the javascript functionality, selenium provides JavascriptExecutor Interface


package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S_42_JavascriptExecutor
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.orangehrm.com/");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.JavascriptUtil javascriptUtil = new GenericUtilities.JavascriptUtil(driver);
		
		By topCarouselBy = By.xpath("//div[@class='carousel-inner']");
		By companyLogoBy = By.xpath("(//img[@alt='OrangeHRM Logo'])[1]");
		By topRightButtonsBy = By.xpath("(//ul[@class='nav navbar-nav navbar-right extended-nav'])[2]");
		
		System.out.println(javascriptUtil.getTitle());
		
		javascriptUtil.scrollToBottom();
		
		Thread.sleep(3000);
		
		javascriptUtil.scrollByPixel("-500");
		
		Thread.sleep(3000);
		
		javascriptUtil.scrollToWebElement(elementUtil.getElement(topCarouselBy));
		
		Thread.sleep(3000);
		
		javascriptUtil.scrollToUp();
		
		Thread.sleep(3000);
		
		javascriptUtil.refreshPage();
		
		Thread.sleep(3000);
		
		javascriptUtil.flashWebElement(elementUtil.getElement(companyLogoBy));
		
		Thread.sleep(3000);
		
		javascriptUtil.drawBorder(elementUtil.getElement(topRightButtonsBy));
		
		Thread.sleep(3000);
		
		System.out.println(javascriptUtil.getpageInnerText());
		
		Thread.sleep(3000);
		
		javascriptUtil.generateAlert("All Javascript actions completed on this page - Thanks");
	}
}
