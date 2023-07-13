// SVG - Scalar Vector Graphs
	// A vector based graphic/ icon in the webpage
// The XPath for an SVG element we get from Chrome Dev Tools is incorrect
// SVG elements have a tag <svg> in DOM
// Special XPath will work with svg elements
// Example
	// Flipkart: Search icon to the right of input search box
		// flipkart search icon: //*[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']   

package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S_49_XPathForSVGElement_01 {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testproject.io/");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		Thread.sleep(5000);
		
		// XPath for SVG element
		//By playVideoSVGIcon = By.xpath("(//*[local-name()='svg'])[2]");
		
		// XPath for SVG child element
		By playVideoSVGChildIconBy = By.xpath("((//*[local-name()='svg'])[2]//*[name()='path'])[2]");
		
		//elementUtil.doClick(playVideoSVGIcon);
		elementUtil.doClick(playVideoSVGChildIconBy); 	
	}
}