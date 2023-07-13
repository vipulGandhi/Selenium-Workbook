// ================================================================================

// Headless: Internally the browser will be opened but not visible - hidden browser
// Advantages
	// Slightly faster
	// We can take screenshot in headless mode
// Disadvantages
	// No visibility of driver actions on WebElements
	// Sometimes it dosen't work for "Move to element", "pop-up"

// Recommended ? - No
	// Only applicable for Sanity test cases

// ================================================================================

// Incognito: Does not maintain any cache or cookies

// ================================================================================

// Launch browser with extention
	// ChromeOptions.addExtensions(local extention path);

// ================================================================================

// disable-notifications: Block browser level notifications
	// Reference: LocalResourceFiles/Images/BrowserNotifications.png


package SeleniumBasics;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class S_07_ChromeOptions
{
	public static void main(String[] args)
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("disable-notifications");
		chromeOptions.addExtensions(new File(System.getProperty("user.dir") + "/LocalResourceFiles/SampleChromeExtentions/extension_0_8_3_0.crx"));		

		// Overloaded constructor of "ChromeDriver" class will be called
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		// Equivalent to:
			// Go to the web-site, right click -> click on "View/ Get Page Source"
		// Javascript/ HTML written for the web-page
		//System.out.println(driver.getPageSource());
		
		driver.quit();
	}
}
