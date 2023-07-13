package SeleniumBasics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_40_FluentWait
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.WaitUtils waitUtils = new GenericUtilities.WaitUtils(driver);
				
		driver.manage().window().maximize();
				
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailIdBy = By.id("input-email");
		
		elementUtil.doSendKeys(waitUtils.isPresenceOfElementLocated_FluentWait(emailIdBy, 10, 500), "User email");
	}
}
