// sendKeys() method accepts CharSequence
// StringBuilder(), StringBuffer(), String() class implements CharSequence interface
// Keys() enum implements CharSequence interface
// sendKeys() does not accepts null and empty string ""


package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_57_SendKeysMethodTeardown
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		WebElement email = driver.findElement (By.id("input-email"));
		
		//append multiple strings with append() method
		StringBuilder username = new StringBuilder()
								.append ( "This")
								.append (" ")
								.append ("Is")
								.append (" " )
								.append ("A")
								.append (" ")
								.append ("Username");
		
		String space = " ";
		
		StringBuffer userInfo = new StringBuffer ()
								.append ("Test")
								.append (" ")
								.append ("WebDriver");
		String author = "Vipul Gandhi";
		
		email.sendKeys(username, space, userInfo, space, author, Keys.TAB);
	}
}
