// Close the specific browser/ tab where driver is available

package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;


public class S_04_DriverCloseLogic
{
	public static void main(String[] args)
	{
		// Request is sent to the server, server launch the browser without a url, creates a new browser session id, shares it with client
		// The session id is maintained between client and server throughout the session 
		WebDriver driver = new FirefoxDriver();
		
		//System.out.println(((FirefoxDriver) driver).getSessionId());
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		
		// Request is sent with the previously generated same session id
		driver.get("https://www.google.com/");
		
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		
		// Request is sent with the previously generated same session id
		System.out.println(driver.getTitle());
		
		System.out.println(((RemoteWebDriver) driver).getSessionId());

		// Request is sent with the previously generated same session id
		driver.close(); // browser is closed thus session is closed. Session id becomes invalid
		System.out.println("Closing the browser ...");
		
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		
		// [Error] org.openqa.selenium.NoSuchSessionException: invalid session id
		// Request is sent with the previously generated same session id
		System.out.println(driver.getTitle()); // Server sends the message:  Invalid session id
		
		// After "driver.close()", reinitialize the driver to get things working again
		// Create a new session id, launch a new browser
		//driver = new FirefoxDriver();
		//driver.get("https://www.google.com/");
		//System.out.println(((RemoteWebDriver) driver).getSessionId());
	}
}
