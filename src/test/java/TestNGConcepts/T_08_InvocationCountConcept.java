package TestNGConcepts;

import org.testng.annotations.Test;

public class T_08_InvocationCountConcept
{
	
	// Use Case
		// In API automation
	@Test (invocationCount = 10)
	public void printNumber()
	{
		System.out.println(" Print a number");
	}
}
