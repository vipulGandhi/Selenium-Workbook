// Task: Get all the options after right clicking the element
package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_28_ActionsClassContextClick
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.ActionsUtil actionsUtil = new GenericUtilities.ActionsUtil(driver);
		
		By rightClickButtonBy = By.xpath("//span[text()='right click me']");
		By rightClickOptionsBy = By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span");
		
		actionsUtil.doRightClick(rightClickButtonBy);

		elementUtil.printAllStringElements(elementUtil.getElementsText(rightClickOptionsBy));
	}
}
