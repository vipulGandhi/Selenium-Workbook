// WebElement.getCssValue("color");

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_62_GetWebElementColor
{

	public static void main(String[] args)
	{		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.nykaa.com/");
		
		By signInButtonBy = By.xpath("//button[text()='Sign in']");
		
		WebElement signInButtonElement = driver.findElement(signInButtonBy);
		
		String buttonColor = signInButtonElement.getCssValue("color");
		String buttonBGColor = signInButtonElement.getCssValue("background-color");
		
		System.out.println("Button Color: " + buttonColor);
		System.out.println("Button BG Color: " + buttonBGColor);
		
		driver.close();
	}
}
