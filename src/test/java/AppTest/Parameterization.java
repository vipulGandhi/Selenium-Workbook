// @Test, @Before, @After Methods can be parameterized
// Parameters annotation is used to read parameters from testng xml for methods in a testng class
// Attribute names provided in Parameters annotations must be same as parameters name provided in testng xml
// Count of attributes in Parameters annotation must be same as count of arguments in that method on which it is used
	// Otherwise it will throw an exception. For Example: If a method accepts two arguments, then @Parameters must have only two attributes
// Attributes are mapped in order as it appears in Parameters annotation with method arguments
	// For example: First attribute in Parameters annotation is mapped to first attribute in method and so on
// In TestNG.xml, Parameters can be passed at suit, test, class and method level 
	// Parameter value at higher level will be overridden by value at lower level if same parameter is passed
		// Parameter value at lower level will be used by @Test methods
		// For example:
			// If we pass a parameter “Param” with value “value1” at suite level
			// Also we pass value “value2” for same parameter “Param” at test level
			// Then parameter “Param” will have value as “value2” at that test level
// In TestNG.xml, we can pass parameters of any data types ("abc", 11, true)
	// @Test method will convert them automatically to required data type


package AppTest;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization
{
	
	String urlName;
	String browserName;
	
	@Parameters({"url", "browser"})
	public Parameterization(String urlString, String browserString)
	{
		urlName = urlString;
		browserName = browserString;
	}
	@Test
	public void getDataFromTestNGMethod01()
	{
		System.out.println(urlName);
		System.out.println(browserName);
	}
	
	public void getDataFromTestNGMethod02(@Optional String urlString, String browserString)
    {
		System.out.println(urlString);
		System.out.println(browserString);
    }
}
