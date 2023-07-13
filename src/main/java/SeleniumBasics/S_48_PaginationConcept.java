// Task: Given a name, find it's origin language

package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S_48_PaginationConcept
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://babynames.merschat.com/popular.cgi");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		By aavishNameBy = By.xpath("//a[contains(text(),'Aavish')]");
		By nextButtonBy = By.xpath("//font[contains(text(),'Next')]");
		By aavisOriginLanguageBy = By.xpath("(//a[contains(text(),'Aavish')]/../../following-sibling::td)[2]//a/font");
		
		
		List<WebElement> aavishNameElement = elementUtil.getElements(aavishNameBy); // Returns only single element
		
		// We do not know the element will be found on which page -> do not know iteration count 
			// Use while loop instead of for loop
		while (true)
		{
			if(!(aavishNameElement.size() == 1))
			{
				elementUtil.doClick(nextButtonBy);
				aavishNameElement = elementUtil.getElements(aavishNameBy); 
			}
			else
			{
				System.out.println(elementUtil.getElementText(aavisOriginLanguageBy));
				break;
			}
		}
	}
}
