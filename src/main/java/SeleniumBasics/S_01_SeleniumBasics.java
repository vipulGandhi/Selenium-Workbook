// Selenium
	// Selenium is a library to help simulate all the user actions on the browser
	// Selenium interacts only with the elements which are present and visible on the web page
	// Selenium is just a web automation tool
	// Selenium is a library/ tool/ set of API/ framework

// Advantages
	// Selenium is only for Web UI automation
	// We can achieve cross-browser testing with selenium
	// Selenium supports multiple OS (Windows, Mac, Linux, Not Unix)
	// Selenium supports multiple languages (Java, Python, Javascript, PhP, C#)
	// It is free and open source
	// Selenium can be integrated with any other 3rd party library (TestNG (Unit testing framework), JUnit, Apache POI etc.)
	// Lightweight, simple, easy to implement
	// Selenium can be integrated with any build automation tools (Maven, Gradel)

// Disadvantages
	// No desktop application can be automated with selenium
	// Selenium is not a testing tool
	// Selenium can't generate any test report (We have to use extent report, allure report, TestNG report)
	// API, performance and security testing could not be done with selenium - Only capable of functional testing
	// It can't automate native mobile applications - Mobile browsers can be automated
	// Can't automate database
		// Can't make connection with oracle or MySql server
		// Language( Eg. Java) is responsible to make connection
	// Don't trust AutoIT/ Robot classes
		// AutoIT/ Robot only works on Windows, it does not work on docker/ linux machine
	// We should never try to automate gmail, facebook, linkedIn - they will block your account

// Selenium Release History:
	// Selenium IDE [2008]
		// Record and play tool, available as firefox extention
	// Selenium RC/ Selenium 1 [2011]
	// Selenium Webdriver/ Selenium 2 [2014]
		// Deprecated Selenium RC
		// Integrated many features of RC with Webdriver
		// Selenium provided browser drivers (Chromedriver, gecodriver etc.)
	// Selenium 3
		// Browser drivers are provided by respective browser vendors
		// Improved performance
	// Selenium 4
		// W3C certified

// Selenium Grid
		// To run the test cases on remote machine
			// Docker/ External Hardware machine/ External Server/ AWS/ Cloud

// Selenium Architecture
	// After the test case is triggered, Selenium code (Client) is converted to Json format
	// Generated Json is sent to Browser Driver(Server) through http(W3C standard protocol) Protocol
		// Each browser has a separate browser driver
	// Browser drivers communicates with its respective browser
		// It executes the commands by interpreting Json which it received on the browser
	// Browser Driver receives responses back from the browser and it sends Json response to Client

// Project Creation
	// Create maven project: Group ID: org.apache.maven.archetypes, Artifact id: maven-archetype-quickstart
		// src/test/java is only for writing test cases
		// Right click project -> New -> Source Folder
			// Name it: src/test/resources
			// This source folder will contain all the external files used in the project
				// Example: testNG.xml, data excel files, config.properties files
		// pom.xml file will be generated
			// POM: Project Object Model
			// Update Maven Compiler plugin to version to 1.8
				/*
				    <properties>
    					<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    					<maven.compiler.source>1.8</maven.compiler.source>
    					<maven.compiler.target>1.8</maven.compiler.target>
  					</properties>
				 */
		// Why maven project 
			// Maven project creates a project structure for us to create the project files wrt. Page Object Model pattern
			// With the Maven pom file
				// We can add 3rd party dependency from maven repository
				// We can setup complete project build process by setting up all the plugins
			// While creating Maven one should provide group id, artifact id & version for the project
				// This information helps in identifying the project uniquely and to store the project in a version control tool

// Automation is generally for Happy Path Scenarios
	// If the application contains too many complex negative scenarios, consider testing them manually


// ---------------------- Real-time scenarios with solution ---------------------------------------------------------

// Scenario A: Verify if all the links on the page - (Linkedin, Facebook, twitter, youtube) are working properly

// Solution - 01
	// Open all the child window, verify the child windows one by one, come back to parent window
		// Driver is present on the parent window
		// Switch the driver to first child window -> Verify the child window -> Close the child window
		// Switch the driver to second child window -> Verify the child window -> Close the child window
		// Switch the driver to third child window -> Verify the child window -> Close the child window
		// Switch the driver to fourth child window -> Verify the child window -> Close the child window
		// Switch the driver again to parent window

// Solution - 02 [Better Approach]
	// Open one child window, verify the child window, come back to parent window
		// Driver is present on the parent window
		// Switch the driver to first child window -> Verify the child window -> Close the child window
		// Switch the driver again to Parent window
		// Switch the driver to second child window -> Verify the child window -> Close the child window
		// Switch the driver again to Parent window
		// Switch the driver to third child window -> Verify the child window -> Close the child window
		// Switch the driver again to Parent window
		// Switch the driver to fourth child window -> Verify the child window -> Close the child window
		// Switch the driver again to Parent window

// -----------------------------------------------------------------------------------------------------------------------

// Scenario B: Random advertisements (or other) pop-ups are coming on the webpage
				// OTP/ Captcha/ 2 Factor Authentication/ File Download/ Link Spidering(Link Scrapping)
	// Solution
		// Can't automate these scenarios
		// Discuss with the developer to block these scenarios in the QA environment
			// In the production or other environments, this scenario can be tested manually
		// OTP/ Captcha are always created to prevent the automation

// -----------------------------------------------------------------------------------------------------------------------


//https://www.softwaretestinghelp.com/manual-to-automation-testing-process-challenges/


