package AppTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class OrangeHRMTest extends _BaseTest
{	
	
	@Test
	public void urlTest()
	{
		String urlString = driver.getCurrentUrl();
		AssertJUnit.assertTrue(urlString.contains("orangehrm")); 
	}
}