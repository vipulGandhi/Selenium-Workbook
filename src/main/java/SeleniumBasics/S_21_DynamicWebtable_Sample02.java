// For a given company, find it's current price


package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_21_DynamicWebtable_Sample02
{

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		String companyNameString = "DCB Bank";
		
		driver.manage().window().maximize();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupall");
		
		By companyCurrentPrice = By.xpath("//a[contains(text(),'"+companyNameString+"')]/../following-sibling::td[3]");
		System.out.println(elementUtil.getElementText(companyCurrentPrice));
	}
}
