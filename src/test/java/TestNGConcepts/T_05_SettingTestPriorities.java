// By default, TestNG sorts method names based on ASCII value of method name first character and then execute them in the ascending order
// To set the priorities, use (priority = n)
	//  Lower priorities will be scheduled first for the execution
	// Only int can be set as priority (-ve, 0, +ve)
// Scenario: Only some of the @Test have priorities attached to them
	// // Test methods without priority will have default priority of Zero and execution sequence will be decided based on ASCII value
// If more than one @Test have same priority, the execution will be based on their alphabetical order
// It is recommended to set the priority as +ve numbers
// Priority is applicable only for @Test methods



package TestNGConcepts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class T_05_SettingTestPriorities
{
	@Test(priority = 4)
	public void a_test()
	{
		System.out.println("a _ test, priority = 4");
	}
	
	@Test (priority = 1)
	public void b_test()
	{
		System.out.println("b _ test, priority = 1");
	}
	
	@Test(priority = 3)
	public void c_test()
	{
		System.out.println("c _ test, priority = 3");
	}
	
	@Test(priority = 2)
	public void d_test()
	{
		System.out.println("d _ test, priority = 2");
	}
}
