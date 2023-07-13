// Types of exceptions
	// Checked Exceptions
		// Handled during compile time
		// FileNotFoundException, IOException etc
	// Unchecked Exception
		// ArrayIndexoutOfBoundException

// Exception Handling
	// Try and Catch block

// Selenium Exceptions
	// NoSuchElementException
		// Incorrect locator
	// NoSuchWindowException
		// WebDriver tries to switch to an invalid window
	// NoSuchFrameException
		// Invalid frame id
	// NoAlertPresentException
	// ElementNotVisibleException/ ElementNotInteractableException
	// TimeoutException
		// If the command is not completed in enough time
	// NoSuchSessionException
	// StaleElementReferenceException
	// ElementNotVisibleException
		// When webdriver is able to locate web element on current webpage but it is not visible on screen
			// Reason: Overlapped by another web element
			// Reason: Execution is performed during ajax calls
			// Solution: 1. Wait till the element gets visible; 2. Use JavaScriptExecutor
			// Reason: Webdriver is unable to auto scroll to desired element
			// Solution: Scroll to element using javascript or Actions class so that element is perfectly visible on screen

// Parent class of all the exceptions is WebDriverException
// WebDriverException is inherited from java.lang.RuntimeException

// Throw and Throws
	// Comes under exception handling 
	// throw keyword throws the exception explicitly from a method or a block of code
	// throws keyword is used in the signature of the method

package SeleniumBasics;

import java.io.IOException;


public class S_65_CustomException
{
	public static void main(String[] args) throws IOException
	{
        try
        {
            // Throw an object of user defined exception
            throw new CustomException01("A Custom Exception Occured ...");
           // throw new ArithmeticException();
        }
        catch (CustomException01 ex)
        {
            System.out.println("Exception caught in catch block");
 
            // Print the message from MyException object
            System.out.println(ex.getMessage());
        }
        
        CustomException01 customException01= new CustomException01(null);  
        customException01.SomeCustomException();  
	}
}

@SuppressWarnings("serial")
class CustomException01 extends Exception
{
    public CustomException01(String message)
    {
        // Call constructor of parent Exception
        super(message);
    }
    
    void SomeCustomException() throws IOException
    {  
    	  System.out.println("IO Exception Occured ...");  
    }  
}


