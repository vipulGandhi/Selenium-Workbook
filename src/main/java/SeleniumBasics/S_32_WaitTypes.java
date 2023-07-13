// Wait concept is also called as synchronization
// Types of wait
	// Static wait
		// Hold the script execution for t seconds
		// Example: Thread.sleep(4000);
	// Dynamic Wait
		// If the wait is applied for 10 seconds and the element is found in 2 seconds, rest of 8 seconds will be ignored
		// Implicit wait
		// Explicit wait
			// Webdriver wait
			// Fluent wait

// Webdriver Wait API Hierarchy
	// Wait Interface [Methods declared: until()]
	// FluentWait<T> class implements Wait interface
		// FluentWait is a generic class
	// FluentWait contains:
		// until() method [Overridden]
		// Class methods
	// WebdriverWait(explicit wait) class extends FluentWait
		// WebdriverWait is only inheriting FluentWait methods
			// Constructors in WebDriverWait internally calls FluentWait constructors
		// WebdriverWait has no class methods of it's own
		// WebdriverWait is also a FluentWait
			// Both can be used interchangeably
		// WebDriverWait wait = new WebDriverWait(driver, 30);
			// It calls constructor of FluentWait<WebDriver> and set default polling interval time to 500 ms

// Misc
	// To handle asynchronous page load and AJAX calls we use selenium wait