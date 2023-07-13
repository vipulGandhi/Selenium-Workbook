// TestNG classes do not require main() method
	// TestNG.class contains main() method which calls the testNG suite internally for execution
// Add TestNG maven dependency to pom.xml
	// To get all TestNG jar files

/*
<dependency>
	<groupId>org.testng</groupId>
	<artifactId>testng</artifactId>
	<version>7.6.1</version>
	<scope>test</scope>
</dependency>
 */

// <scope>test</scope>
	// It signifies it's scope will be limited to src/test/java
	// Prefer removing the scope

// Install plugin 
	// Required to run TestNG classes - As they have no main() method
	// Go to Eclipse -> Help -> Eclipse Marketplace
		// Search for TestNG -> Install

// TestNG is a Java Unit testing framework

// TestNG does not allow any type of parameters in @Test method
// We can create overloaded methods or add parameters in TestNG @Test method using @dataProvider

// TestNG Inheritance
	// TestNG supports child TestNG(@Test) class inheriting parent TestNG(@Test)
	// Firstly child class @Test methods will be executed then parent class @Test methods
	// If some methods are overridden in the child class:
		// Only overridden method will be executed and parent method of super class will be ignored 

//TestNG could be used with Selenium, RestAssured, Appium

// Create testng.xml file
	// Right click project -> TestNG -> Convert to TestNG
		// testng.xml file will be created
		// Create a resource folder if not already present
			// Right click project -> New -> Source Folder
				// Name it: src/test/resources
				// This source folder will contain all the external files used in the project
					// Example: xml files, json files, properties, excel sheets etc
		// Under the resource folder, create a folder, name it - testrunners
			// Move testng.xml to this folder
	// To create more testng.xml files
		// Right click project -> New -> file
			// name the file (with extension .xml)
			// Copy below code to the newly created file - this code defined the file to be an xml
				/*
	
			 	<?xml version="1.0" encoding="UTF-8"?>
				<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
				
				 */

// TestNG Reports
	// After running testNG.xml file, refresh the project
	// A new folder "test-output" will be created
		// index.html and emailable-report.html file inside this folder contains the test report in HTML format
	// To re - run failed test cases only:
		// Under the Suit folder, go to testng-failed.xml
			// Run testng-failed.xml to run only failed test cases

// To run a single @Test from a class
	// Click on the test name  -> Run As -> TestNG Test

// In TestNG, we do not do method overloading with @Test

// All @Test methods should be appended with Test
	/*
	 	@Test
		public void loginTest()
		{
		}
	 */

// Rerun failed test case
	// IRetryAnalyzer is an interface in org.testng package
	// It has only method named retry
	// By overriding/ implementing this method in a class, we can control the number of attempts to rerun a failed test case
	// Add retry mechanism for each and every @Test method
		// IAnnotationTransformer
			// With this interface, we can read or write to any TestNG annotation
			// This interface has only method named “transform”
			// Method “transform has a parameter of type ITestAnnotation interface
				// ITestAnnotation has a method to set (setRetryAnalyzer) and get (getRetryAnalyzer) RetryAnalyzer at run time
				// We have to pass our implemented class of IRetryAnalyzer interface as an argument to setRetryAnalyzer() method
			// Add IAnnotationTransformer implementation class in TestNG.xml under <listeners> tag
	// http://makeseleniumeasy.com/2018/12/30/iretryanalyzer-in-testng-using-retryanalyzer-attribute-of-test-annotation/
	// http://makeseleniumeasy.com/2019/01/01/testng-tutorials-69-rerun-failed-test-method-using-iretryanalyzer-interface-implementing-as-a-listener-itestannotationtransformer/


// @Test annotated method can return a value
	// but that method will not be considered as a test method for TestNG anymore i.e. TestNG will ignore that method execution

// Skipping a Test Conditionally in TestNG
	// How to skip a test conditionally? ==> Using skipException class
	// How conditionally skipped test is reported in TestNG report? ==> As a skipped test case

// Share Data Among Test Methods in TestNG - use ITestContext
	/*
		public void generateData(ITestContext context)
		{
			context.setAttribute("FirstName", "Vipul");
			String myFirstName = (String) context.getAttribute("FirstName");
		}
	*/

// https://medium.com/@iamfaisalkhatri/working-with-multiple-testng-xml-files-f5c36896d6b6
