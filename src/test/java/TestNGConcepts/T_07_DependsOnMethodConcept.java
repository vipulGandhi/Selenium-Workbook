// Scenario: If loginTest() fails/ throws uncaught exception then searchTest() and dashboardPageTest() should be skipped

// Rule of writing unit tests: @Test should be independent
	// Dependency among @Test should not be created
// @Test should be executed with any random order
// Every @Test should have
	// It's own precondition
	// Test steps
	// Assertions
	// Result status
// Not recommended - (dependsOnMethods = "MethodName")

// If the precondition fails (Example: BeforeTest()) - All the following @Test methods will be skipped

package TestNGConcepts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class T_07_DependsOnMethodConcept
{
	
	@BeforeTest()
	public void launchBrowser()
	{
		System.out.println("Launching the browser ...");
		//int a = 10/0;
	}
	
	@Test
	public void createUserTest()
	{
		System.out.println("Creating a user before login ...");
		//int a = 10/0;
	}
	
	@Test
	public void loginTest()
	{
		System.out.println("Login to app ...");
		// int a = 10/0;
	}
	
	@Test(dependsOnMethods = {"loginTest", "createUserTest"}, priority = 1)
	public void dashboardPageTest()
	{
		System.out.println("Home page test ...");
	}
	
	@Test (dependsOnMethods = {"loginTest", "createUserTest"}, priority = 2)
	public void searchTest()
	{
		System.out.println("Searching somthing after login ...");
	}
}
