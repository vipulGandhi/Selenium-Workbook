// Get tool-tip data for every element of EMI Bar Chart
// Reference: https://www.youtube.com/watch?v=J-Zc02wp-6E

package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_49_XPathForSVGElement_02
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://emicalculator.net/");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		GenericUtilities.ActionsUtil actionsUtil = new GenericUtilities.ActionsUtil(driver);
		GenericUtilities.JavascriptUtil javascriptUtil = new GenericUtilities.JavascriptUtil(driver);
		
		Thread.sleep(5000);
		
		By emiBarChartBy = By.id("emibarchart");
		By emiBarChartElementsBy = By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']");
		
		//System.out.println(elementUtil.getElementsCount(verticalHighChartBy));
		
		List<WebElement> allVerticalToolarElements = elementUtil.getElements(emiBarChartElementsBy);
		
		javascriptUtil.scrollToWebElement(elementUtil.getElement(emiBarChartBy));
		
		for (WebElement webElement : allVerticalToolarElements)
		{
			// Go to the element one by one to access their tool-tip
			actionsUtil.doMoveToElement(webElement);
			Thread.sleep(200);
		}
	}
}
