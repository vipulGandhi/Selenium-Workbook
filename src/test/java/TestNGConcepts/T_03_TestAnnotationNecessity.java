// Because there is no Test(no @Test annotation), this TestNG class can't be run

package TestNGConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


public class T_03_TestAnnotationNecessity
{
	
	WebDriver driver;

	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.co.in/");
	}
}
