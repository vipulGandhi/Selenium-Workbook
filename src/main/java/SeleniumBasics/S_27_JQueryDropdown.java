// A dropdown with no <select> tag could be a jquery dropdown
// Dropdown with multiple choices often does not contains <select> tag -> They are created with <ui> and <li> tags


// Task: Select the given checkboxes
package SeleniumBasics;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//Good
public class S_27_JQueryDropdown
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		
		List<String> checkboxesToSelect = new ArrayList<String>();
		checkboxesToSelect.add("choice 1");
		checkboxesToSelect.add("choice 2 3");
		checkboxesToSelect.add("choice 6 2 3");
		checkboxesToSelect.add("choice 7");
		
		GenericUtilities.ElementUtil elementUtil = new GenericUtilities.ElementUtil(driver);
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		By multiSelectionInputbox =  By.id("justAnInputBox");
		elementUtil.doClick(multiSelectionInputbox);
		
		By checkBoxElementsBy = By.xpath("//input[@id='justAnInputBox']/../following-sibling::div//input[@type='checkbox']/..");
		elementUtil.SelectWebelementsFromList(elementUtil.getElements(checkBoxElementsBy), checkboxesToSelect);
	}
}
