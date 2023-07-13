// Move one element from one frame to another frame
// Draggable webelement is present in the first frame
// Droppable item is present in the second frame

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S_71_MoveElementFromOneFrameToOtherFrame
{
	public static void main(String[] args)
	{		
		WebDriver driver = new ChromeDriver();
		
		driver.get("some url");
		
		Actions actions = new Actions(driver);
		
		driver.switchTo().frame("first frame id");
		WebElement draggableElement = driver.findElement(By.xpath(null));
		actions.moveToElement(draggableElement).clickAndHold().build().perform();;
		
		driver.switchTo().frame("second frame id");
		WebElement droppablElement = driver.findElement(By.xpath(null));
		actions.moveToElement(droppablElement).release().build().perform();
		
		driver.switchTo().defaultContent();
	}
}
