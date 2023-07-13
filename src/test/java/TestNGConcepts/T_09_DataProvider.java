// DataProvider annotated method returns an array of array of objects
	// It can be any dimensional (1D/ 2D/ 3D ... array)
// Number of values passed by a DataProvider method should be equal to number of attributes of test method on which DataProvider method is used
	// If DataProvider methods provided three attributes, test method must accept three attributes and vise versa.
// If attributes counts are not matching at both sides
	//Exception: “org.testng.internal.reflect.MethodMatcherException: Data provider mismatch” exception
// Access DataProvider methods from another class:
	// Inheritance
		// Child @Test class extends parent @DataProvider class
	// Static or Non-static DataProvider Methods
		// If @DataProvider class has parameterised constructors
			// Declare dataprovider methods as Static
		// If @DataProvider has no/ default constructor
			// Declare data provider methods as either static or non-static
		// In the @Test Class, use
			// @Test(dataProvider = @DataProviderMethodName, dataProviderClass = DataProviderClassName.class)
// By default a Test method is executed for all data set returned by DataProvider
	// DataProvider annotated method has an attribute called “indices” whose default value is set to “all”. It starts from 0
// @Test method runs on data in the same sequence in which DataProvider pass it
	// The reason behind this is that a DataProvider annotated method has an attribute named “parallel” whose default value is set to “false”
	// To run @Test in parallel
		// @DataProvider(parallel=true)
		// TestNG.xml: <suite name="Suite" data-provider-thread-count="20" >
			// Default size of "data-provider-thread-count": 10
// Return type of @DataProvider method could be Object[][] or String[][] or Integer[][]

package TestNGConcepts;

import org.testng.annotations.Test;

public class T_09_DataProvider
{
	@Test(dataProvider = "Set of numbers", dataProviderClass = T_02_Annotations.class)
	public void PrintNumbers(int value1, int value2, int value3)
	{
		System.out.println("Printing Numbers: " + value1 + ", " + value2 + ", " + value3);
	}
	
}
