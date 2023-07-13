package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.JavascriptUtil;

public class S_49_PaginationConcept
{

	public static void main(String[] args)
	{		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		List<WebElement> headerWebElement;
		
		driver.get("https://infinite-scroll.com/demo/full-page/");
		
		JavascriptUtil javascriptUtil = new JavascriptUtil(driver);
		
		By headerText = By.xpath("//h2[@id='3d-holograms']");
		
		headerWebElement = driver.findElements(headerText);
		
		if(headerWebElement.size() > 0)
		{
			System.out.println("Element text is: " + headerWebElement.get(0).getText());
		}
		else
		{
			while (headerWebElement.size() <= 0)
			{
				javascriptUtil.scrollByPixel("1");
				headerWebElement = driver.findElements(headerText);
			}
		}
		
		System.out.println("Element text is: " + headerWebElement.get(0).getText());
	}
}