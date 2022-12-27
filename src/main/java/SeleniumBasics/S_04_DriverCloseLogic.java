// Close the specific browser where driver is available

package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S_04_DriverCloseLogic
{
	public static void main(String[] args)
	{
		
		WebDriverManager.chromedriver().setup();
		
		
		// Request is sent to the server, server creates a new session id and share with client
		// The session id is maintained between client and server throughout the session 
		WebDriver driver = new ChromeDriver();
		
		// Request is sent with the previously generated same session id
		driver.get("https://www.google.com/");
		
		// Request is sent with the previously generated same session id
		System.out.println(driver.getTitle());

		// Request is sent with the previously generated same session id
		driver.close(); // browser is closed. Session id becomes invalid
		
		// [Error] org.openqa.selenium.NoSuchSessionException: invalid session id
		// Request is sent with the previously generated same session id
		System.out.println(driver.getTitle()); // Server sends the message:  Invalid session id
		
		// After "driver.close()", reinitialize the driver to get things working again
		// Create a new session id, launch a new browser
		//driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
	}
}
