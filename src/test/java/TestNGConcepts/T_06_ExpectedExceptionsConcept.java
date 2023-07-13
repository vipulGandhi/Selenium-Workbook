// If any exception is expected from @Test execution, use (expectedExceptions = ExceptionClass)
// expectedExceptions is a class array, can add multiple exception classes to it
// If (expectedExceptions = ExceptionClass) is attached to @Test. Then at least one exception defined in it should always occur.
	// [org.testng.TestException] if non of the expectedExceptions occurs during the @Test execution
// The @Test will throw an exception if we get any other exception which is not defined in "expectedExceptions"
// If we are sure that the exception will occur but not sure which particular exception will occur, we may use "Exception.class"
	// "Exception.class" is the parent class of all exception classes
	// We can also use "Throwable.class" - It is the parent class of "Exception.class"
// As we are attaching (expectedExceptions = ExceptionClass) to @Test, writing a try-catch block(to catch the exception) is not required
	// expectedExceptions = ExceptionClass expect itself to handle the exception rather than @Test handling the same exception with try-catch block
// Not used much in automation



package TestNGConcepts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class T_06_ExpectedExceptionsConcept
{
	
	String usernameString = "User Name";
	
	@Test (expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void loginTest()
	{
		System.out.println("Login test ...");
		int a = 10/ 0;
	}
}
