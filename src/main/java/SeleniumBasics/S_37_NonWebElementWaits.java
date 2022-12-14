package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S_37_NonWebElementWaits
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.WaitUtils waitUtils = new GenericUtilities.WaitUtils(driver);
		
		driver.get("https://www.freshworks.com/");
		
		By testCaseLinkBy = By.linkText("Support");
		elementUtil.doClick(testCaseLinkBy);
		
		System.out.println(waitUtils.ifUrlContainsText("support", 2));
		System.out.println(waitUtils.ifTitleContainsText("Freshworks Support", 5));
	}
}
