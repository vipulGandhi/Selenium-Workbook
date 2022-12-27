// Webdriver API
	// Interface: SearchContext [Methods declared: FindElement(), FindElements()]
	// Interface: WebDriver extends SearchContext [Methods declared: get(), click(), sendKeys(), close()] etc.
	// Class: "RemoteWebDriver implements WebDriver, JavaScriptExecutor and TakeScreenshot
		// All the methods of WebDriver interface is implemented in RemoteWebDriver
		// RemoteWebDriver class can execute WebDriver commands on a browser running on a different (remote) machine
		// RemoteWebDriver driver = new ChromeDriver(); can also be used against WebDriver driver = new ChromeDriver(); [Will work 100%]"
			// Java standard says: Do top-casting with the parent interface [WebDriver driver = new ChromeDriver()] is better
	// ChromiumDriver(class) extend RemoteWebDriver, ChromeDriver(class) extend ChromiumDriver
	// FirefoxDriver(class) extends RemoteWebDriver

// [Error] org.openqa.selenium.SessionNotCreatedException
	// Reason
		// Chromedriver and chrome browser version are mismatched

// All the messages printed in console is not error messages but Info.

// Apple does not provide any driver server executable for safari browser.
	// Selenium itself handles safari
	// No need to write "System.setProperty" for safari
	// WebDriver driver = new SafariDriver(); // is sufficient



package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S_02_WebdriverBasics
{

	public static void main(String[] args)
	{
		//Windows
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		
		//Mac
		// [Cons] For every browser update, we have to download respective chromedriver file
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver");
		
		// [Pros] For every browser update, no need to download respective chromedriver file
			// It checks in .m2 directory for the browser supported server executable (eg. chromedriver.exe)
				// If the server executable is not present, it downloads the file
		WebDriverManager.chromedriver().setup();
		
		// Top Casting
			// Advantage: Use same reference variable to launch different browsers
		// Child class object is referred by parent interface reference variable
		// As the object of "ChromeDriver()" class is created, it's constructor also gets called.
			// The logic to launch the browser is written in the class constructor
		WebDriver driver = new ChromeDriver(); // Launch chrome browser
		
		
		//[Error] org.openqa.selenium.InvalidArgumentException
		// It is compulsory to pass "http" or "https"
		//driver.get("www.google.com/");
		
		// [Remove www] Works properly
		//driver.get("https://google.com/");
		
		driver.get("https://www.google.com/");
		
		// Quit browser
		driver.quit();
	}
}
