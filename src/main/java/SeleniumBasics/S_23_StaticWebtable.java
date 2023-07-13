// Static web table
// Task - 01: Print all company names [Good]
// Task - 02: If the company name is "Island Trading" then print it's entire row
// Task - 03: Iterate through every element of webtable

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_23_StaticWebtable
{

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		String companyNameString = "Island Trading";
		WebElement companyRowWebElement = null;
		
				
		driver.manage().window().maximize();
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		// Task - 01
		By companyNamesBy = By.xpath("//table[@class='ws-table-all']//tr/td[1]");
		elementUtil.printAllStringElements(elementUtil.getElementsText(companyNamesBy));
		
		System.out.println();
		
		// Task - 02
		// Get the parent element
		for (WebElement webElement : elementUtil.getElements(companyNamesBy))
		{
			if(webElement.getText().trim().toLowerCase().equals(companyNameString.trim().toLowerCase()))
			{
				companyRowWebElement = webElement.findElement(By.xpath(".."));
			}
		}
		
		// Print all children of parent element
		for (WebElement webElement : companyRowWebElement.findElements(By.xpath("td")))
		{
			System.out.println(webElement.getText());
		}
		
		System.out.println();
		
		// Task - 03
		for (WebElement webElement : driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/td")))
		{
			System.out.println(webElement.getText());
		}
	}
}
