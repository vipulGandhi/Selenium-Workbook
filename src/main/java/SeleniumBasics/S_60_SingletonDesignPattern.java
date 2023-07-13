// Singleton
	// The class should have only one object at any time
	// Useful when we need to use same object of a class across all classes or framework
	// Singleton class must return the same instance, if it is instantiated again

// To create a singleton class
	// Declare constructor of class as private so that it's object can't be created in any other class
	// Create a private static reference variable of class. Static is needed to make it available globally
	// Create a public static method with return type as object of class which should check if class is already instantiated

// 2 Ways to call the webdriver from multiple test classes in a framework
	// Way 1. Create the webdriver class as singleton
	// Way 2. Let all the test classes use an inherited class instance of the webdriver
		// Create a BaseTest class, get the webdriver instance
		// Create the child test classes to use that webdriver instance

//  If we are maintaining a test suite with multiple Page Objects, multiple test files, etc. then 2nd way is a good approach
		//  It helps use WebDriver objects both efficiently and in a thread-safe manner

package SeleniumBasics;


public class S_60_SingletonDesignPattern
{
	private S_60_SingletonDesignPattern()
	{
		System.out.println("Object Created");
	}
	
	private static S_60_SingletonDesignPattern genericSingleton = null;
	
	public static S_60_SingletonDesignPattern init()
	{
		if(genericSingleton == null)
			genericSingleton = new S_60_SingletonDesignPattern();
		
		return genericSingleton;
	}
}
