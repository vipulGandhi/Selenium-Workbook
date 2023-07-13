// Enter text in capital letters in the first name box

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class S_58_ActionsClassKeyboardActions
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		
		GenericUtilities.ActionsUtil actionsUtil = new GenericUtilities.ActionsUtil(driver);
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		By firstNameInputFieldBy = By.name("firstName");
		
		
		Keys inputKeys = Keys.SHIFT;
		
		actionsUtil.inputKeyboardKeysDown(elementUtil.getElement(firstNameInputFieldBy), inputKeys);
		
		elementUtil.getElement(firstNameInputFieldBy).sendKeys("Hello World");
	}
}
