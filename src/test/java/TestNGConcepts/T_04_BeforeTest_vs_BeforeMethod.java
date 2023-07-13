// Scenario - 01
	// setup() and tearDown() method with @@BeforeTest, @AfterTest annotation
		// Advantage:
			// Good Performance
		// Disadvantages
			// Browser is launched only once
			/* Suppose during any one @Test execution, the browser is crashed,
			 * the setup() method (in which browser launched and other initialization code is written)
			 * will not be executed again. Due to this, subsequent @Test will not get executed  */
		// When to use
			// When the number of @Test cases is small (20 - 40 @Test)
			// During smoke testing
			// Application is stable

// Scenario - 02
	// setup() and tearDown() method with @@BeforeMethod, @AfterMethod annotation
		// Disadvantage:
			// Bad Performance
		// Advantage
			// Browser is launched for every @Test case
			/* For every @Test, setup() and tearDown() methods will be called - it is like fresh start for every test case
			 *  - which is good (The browser will be re launched, cookies, cache will be deleted before the test etc.)*/
		// When to use
			// When the number of @Test cases is very large
			// During regression testing
			// Application development is in initial phase - where @Test are more likely to fail

			

package TestNGConcepts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class T_04_BeforeTest_vs_BeforeMethod
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
	
	
	@Test
	public void searchFieldTest()
	{
		boolean flag = driver.findElement(By.name("q")).isDisplayed();
		
		// Assert class is overloaded
		AssertJUnit.assertTrue(flag);
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
