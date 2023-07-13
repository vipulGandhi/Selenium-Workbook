// For more than one @Test, the execution order will be alphabetical - sequence doesn't matter
// alwaysRun
	// @Test(alwaysRun=true)
	// Default value = false
	// Can be used with @Before and @Test annotations
	// If set to true, this test method will always run even if it depends on a method that failed


package TestNGConcepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


// Ignore all @Test annotated method of a Class
//@Ignore
public class T_02_Annotations
{
	// Global preconditions
		// Before running complete regression suite
	@BeforeSuite
	public void databaseConnection()
	{
		System.out.println("[Before Suite] Database connected ...");
		System.out.println("[Before Suite] Print running test details ...");
		System.out.println("[Before Suite] Print active browser, Project Name ...");
	}
	
	@BeforeTest
	public void createUser()
	{
		// With any api's available or with any sql query, create a user
		System.out.println("[Before Test] User created ...");
	}
	
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("[Before Class] Browser launched ...");
	}
	
	@BeforeMethod
	public void loginToApplication()
	{
		System.out.println("[Before Method] Logged in ...");
	}
	
	@DataProvider(name = "Set of numbers")
	public static Object[][] DifferentNumbers()
	{
		Object [][] numberSet=new Object[2][3];
		numberSet[0][0] = 0;
		numberSet[0][1] = 1;
		numberSet[0][2] = 2;
		numberSet[1][0] = 3;
		numberSet[1][1] = 4;
		numberSet[1][2] = 5;
		
		return numberSet;
	}
	
	// Method name should always end with "Test" with every @Test annotation
	@Test
	public void userInfoTest()
	{
		System.out.println("[Test] User info test ...");
	}
	
	@Test
	public void accountInfoTest()
	{
		System.out.println("[Test] Account info test ...");
	}
	
	// This test method is ignored/disabled using @Ignore attribute. The same can be achieved using enabled=false.
	@Test @Ignore
	public void inactiveTest()
	{
		System.out.println("I am an inactive test ...");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("[Afer Method] Logout ...");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("[After Class] Close the browser ...");
	}
	
	@AfterTest
	public void deleteUser()
	{
		System.out.println("[After Test] User Deleted ...");
	}
	
	@AfterSuite
	public void disconnectDatabase()
	{
		System.out.println("[After Suite] Database disconnected ...");
		System.out.println("[After Suite] Upload and send report ...");
		System.out.println("[After Suite] Cleanup resources ...");
	}
}
