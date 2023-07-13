// Webdriver API
	// Interface: SearchContext [Methods declared: FindElement(), FindElements()]
	// Interface: WebDriver extends SearchContext [Methods declared: get(), click(), sendKeys(), close()] etc.
		// Webdriver also extends:
			// Options interface [Delete cookie, set cookie etc.]
			// TimeOut Interface
			// Navigation interface
	// Class: "RemoteWebDriver implements WebDriver, JavaScriptExecutor and TakeScreenshot
		// All the methods of WebDriver interface are implemented in RemoteWebDriver
		// RemoteWebDriver class can execute WebDriver commands on a browser running on a remote machine
		// RemoteWebDriver driver = new ChromeDriver(); can also be used against WebDriver driver = new ChromeDriver(); [Will work 100%]"
			// Java standard says: Do top-caste with the parent interface. WebDriver driver = new ChromeDriver() is better
		// All implementations of WebDriver that communicate with the browser server shall use a common protocol (W3C Protocol)
			// This protocol defines a RESTful web service using JSON over HTTP
			// The role of RemoteWebDriver is to construct a request for specific browser to perform the actions
			// All request are sent to browser specific servers i.e. executable files
		// RemoteWebDriver has implementation to call RESTful Web Services of Selenium WebDriver which hits to respective browser server
			// It has no mechanism to perform any browser specific action
	// ChromiumDriver(class) extend RemoteWebDriver, ChromeDriver(class) extend ChromiumDriver
	// FirefoxDriver(class) extends RemoteWebDriver

// Extend vs Implement
	// extends is for extending a class or interface
	// implements is for implementing an interface
		// Sub-class extends parent class
		// Sub-class implements an Interface
		// Interface extends Interface

// [Error] org.openqa.selenium.SessionNotCreatedException
	// Reason: Chromedriver is unable to launch the browser. Chromedriver and Chrome browser versions are mismatched

// All the messages printed in console are not error messages but Info

// Apple does not provide any browser server executable file for safari browser
	// Selenium itself handles safari
	// No need to write "System.setProperty" for safari
	// WebDriver driver = new SafariDriver(); // is sufficient

// TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
	// Down cast WebDriver reference to TakesScreenshot

// Why is WebDriver is an interface but not a class
	// WebDriver defines a contract to follow by all the browsers
		// The browser drivers can implement the contract methods as per their convenience
	// WebDriver could be an abstract class as well but idea behind making WebDriver is an interface for better architectural design



package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


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
		//WebDriverManager.firefoxdriver().setup();
		
		// Top Casting
			// Advantage: Use same reference variable to launch different browsers
		// Child class object is referred by parent interface reference variable
		// As the object of "FirefoxDriver()" class is created, it's constructor also gets called.
			// The logic to launch the browser is written in the class constructor
		WebDriver driver = new FirefoxDriver(); // Launch firefox browser
		
		// Method chaining
			// obj.method1().method2().method3(); 
			// When a constructor is called, the constructor does not hold any return type, but it returns the current object reference
			// The returned object reference is calling the next method
		// Builder Pattern
		driver.manage().window().maximize();
		
		//[Error] org.openqa.selenium.InvalidArgumentException
		// It is compulsory to pass "http" or "https"
		//driver.get("www.google.com/");
		
		// [Remove www] - works properly
		//driver.get("https://google.com/");
		
		driver.get("https://www.lenskart.com");
		
		System.out.println(driver.getTitle());
		
		// Quit browser
		driver.quit();		
	}
}
