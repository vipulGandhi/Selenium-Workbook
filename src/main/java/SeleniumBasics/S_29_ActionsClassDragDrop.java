// Drag drop one webelement to other webelement

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class S_29_ActionsClassDragDrop
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.ActionsUtil actionsUtil = new GenericUtilities.ActionsUtil(driver);
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		By draggabelElementBy = By.id("draggable");
		By droppableElementBy = By.id("droppable");
		
		actionsUtil.doDragAndDrop(draggabelElementBy, droppableElementBy);
	}
}
