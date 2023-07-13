// A seperate @DataProvider class and Iterator to a list is used when:
	// Number of data (arguments) is more
	// Data keeps changing
	// We do not know the required number of data in advance
	// Number of parameters is dynamic

// A problem with a DataProvider method is that we must match number of arguments returned by DataProvider method and its caller Test method
	// Using above concept number of argument dependency can be eliminated

package TestNGConcepts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T_11_DataProviderExample
{
	// A DataProvider method which returns an iterator to a list
	// Each iteration will be a set of data for a @Test method to run on
	@DataProvider(name="DataProviderIterator")
	public Iterator<T_10_DataProviderClass> studentDetails()
	{
		List<T_10_DataProviderClass> studentList = new ArrayList<T_10_DataProviderClass>();
		studentList.add(new T_10_DataProviderClass("Kiran", 15, "Male"));
		studentList.add(new T_10_DataProviderClass("Amod", 20, "Male"));
		studentList.add(new T_10_DataProviderClass("Anu", 25, "Female"));
		return studentList.iterator();
	}
 
    // Test method accepting Student type attribute ( Not an Iterator)
		// Test method needs to accept type of Object returned by Iterator
	@Test(dataProvider = "DataProviderIterator")
	public void Studentregistration(T_10_DataProviderClass student)
	{
 
		if(student.validateAge())
		{
			System.out.println("Student registered with details as Name = "+student.name + " , Age ="+student.age +" , Gender ="+student.gender);
		}
		else
		{
			System.out.println("Student not registered with details as Name = "+student.name + " , Age ="+student.age +" , Gender ="+student.gender);
		}
 
	}
}
