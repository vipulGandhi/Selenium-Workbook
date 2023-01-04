// Implicit wait should never be used
// Implicit wait is dynamic in nature
// The default setting of implicit wait is zero
// It is a global wait
	// The wait will be applicable for all the webelements following implicit wait initialization
	// This phenomenon is not affected by page switching because the implicit wait is tied to the driver
		// For a different page, we may override the implicit wait
			// Login page: 10 seconds
			// Home page: 12 seconds
			// Contacts page: 8 seconds
// Drawback_01: We have to override implicit wait for different pages
// Drawback_02: A global wait is applied to each and every element
// Drawback_03: The driver has to continuously check in the background if it need to apply implicit wait or not
// Drawback_04: It will not catch potential bugs
	// This bug will remain un-noticed:
		// Implicit wait is initialized with 5 seconds. One element should not take more than 2 seconds to load in the webpage
			// With implicit wait defined, it can take up to 5 seconds to load
// Drawback_05: It is only and only applicable for web elements. It can not be applied for non-web elements
	// It can not be applied for:
		// Alerts, url, page titles
			// url is taking time to load during navigation
				// may use pageLoadTimeout
					// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			// page title is taking time to display 
			// Alert is taking time to display
// Once the DOM is loaded, all the DOM elements will be visible on the page
// We can nullify the implicit wait during program execution
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
// Implicit Wait: Default polling time 500 ms
	// If the wait is of 10 seconds, after every 500 ms, selenium poll the application for element presence



package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S_34_ImplicitWaitConcept
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		
		// Page timeout
		// If the page does not load within 10 seconds, Exception will be thrown
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		// Invalid locator
		// Due to Implicit wait, the error will be thrown after 10 seconds 
		// [Exception] org.openqa.selenium.NoSuchElementException
		By usernameBy = By.id("login1Dummy");
		elementUtil.doSendKeys(usernameBy, "Username");
	}
}
