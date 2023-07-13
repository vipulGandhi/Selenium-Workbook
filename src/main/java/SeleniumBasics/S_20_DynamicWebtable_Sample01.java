// Structure:
	// <table>
		// <tbody>
			// multiple <tr> (table rows)
				// Every <tr> has multiple <td> (table columns)
					// <td> can have multiple child elements

//Get parent element
// WebElement parent = child.findElement(By.xpath(".."));

// Task: Find the company in group A whose %change is highest


package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_20_DynamicWebtable_Sample01
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		WebElement firstAGroupElement = null;
		WebElement aGroupElementSiblingCompanyElement = null;
		
		driver.manage().window().maximize();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupall");
		
		// Get all group elements
		By allGroupsElementsBy = By.xpath("//table[@class='dataTable']//tr/td[2]");
		List<WebElement> allGroupsElements = elementUtil.getElements(allGroupsElementsBy);
		
		// Select 1st group A element
		for (WebElement webElement : allGroupsElements)
		{
			if(webElement.getText().equals("A"))
			{
				firstAGroupElement = webElement;
				break;
			}
		}
		
		// Get the company name [Method - 01]
			// From group A element, go to parent element --> from parent element get the company name element
		aGroupElementSiblingCompanyElement = firstAGroupElement.findElement(By.xpath("../td/a"));
		
		// Print the text of company name element
		System.out.println(aGroupElementSiblingCompanyElement.getText());
		
		// Get the company name [Method - 02]
			// From group A element, go to the sibling company element
		//aGroupElementSiblingCompanyElement = firstAGroupElement.findElement(By.xpath("preceding-sibling::td"));
		aGroupElementSiblingCompanyElement = firstAGroupElement.findElement(By.xpath("preceding-sibling::td/a"));
		System.out.println(aGroupElementSiblingCompanyElement.getText());
		
		// Get the company name [Method - 03]
		aGroupElementSiblingCompanyElement = driver.findElement(By.xpath("(//table[@class='dataTable']//td[text()='A']/../td/a)[1]"));
		System.out.println(aGroupElementSiblingCompanyElement.getText());
	}
}
