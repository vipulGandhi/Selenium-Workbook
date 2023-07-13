package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_24_Cricinfo_XPath
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/43096/ind-vs-ned-23rd-match-super-12-group-2-icc-mens-t20-world-cup-2022");
		
		// Task: Who took the wicket of KL Rahul
		By rahulWicketTaker = By.xpath("//div[@id='innings_1']//a[contains(text(),' Rahul')]/parent::div/following-sibling::div[1]/span");
		System.out.println(elementUtil.getElementText(rahulWicketTaker));
		
		// Task: Get Kohli score card
		By kohliStatsBy = By.xpath("//div[@id=\"innings_1\"]//a[contains(text(),'Kohli')]/parent::div/following-sibling::div");
		System.out.println(elementUtil.getElementsText(kohliStatsBy));
	}
}
