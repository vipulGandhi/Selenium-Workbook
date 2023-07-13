// Task: Go to "sign up" link from "Email address" input field
	// Solution: use "ancestor"

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_22_DynamicWebtable_Sample03
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://app.hubspot.com/login");
		
		By signUpBy = By.xpath("//input[@id='username']/ancestor::form[@id='hs-login']/div[@class='signup-link']/a");
		//By signUpBy = By.xpath("//input[@id='username']/../../../../../div[@class='signup-link']/a");
		
				
		elementUtil.doClick(signUpBy);
	}
}
