package TestNGConcepts;

public class T_10_DataProviderClass
{
	String name;
	int age;
	String gender;
	
	public T_10_DataProviderClass(String name, int age, String gender)
	{
		this.name= name;
		this.age=age;
		this.gender=gender;
	}
	
	// A method to check if student is eligible for registration
	public boolean validateAge()
	{
		if(this.age >= 20)
		{
			System.out.println("You are eligible to do registration.");
			return true;
		}
		else
			return false;
	}
}
