package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S_05_DriverQuitLogic
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		
		
		// Request is sent to the server, server creates a new session id and share with client
		// The session id is maintained between client and server throughout the session 
		WebDriver driver = new ChromeDriver();
		
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		
		// Request is sent with the previously generated same session id
		driver.get("https://www.google.com/");
		
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		
		// Request is sent with the previously generated same session id
		System.out.println(driver.getTitle());
		
		System.out.println(((RemoteWebDriver) driver).getSessionId());

		// Request is sent with the previously generated same session id
		driver.quit(); // browser is closed. Session id is deleted
		
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		
		// [Error] org.openqa.selenium.NoSuchSessionException: Session ID is null
		// Request is sent with the previously generated same session id
		System.out.println(driver.getTitle()); // Server sends the message:  Session ID is null
		
		// After "driver.quit()", reinitialize the driver to get things working again
		// Create a new session id, launch a new browser
		//driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
	}
}

