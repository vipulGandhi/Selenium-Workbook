package SeleniumBasics;

public class S_03_AmazonTest
{
	
	public static void main(String[] args)
	{
		GenericUtilities.BrowserUtil browserUtil = new GenericUtilities.BrowserUtil();
		
		browserUtil.launchBrowser("firefox");
		browserUtil.enterURL("https://www.amazon.in/");
		
		String url = browserUtil.getCurrentURL();
		if(url.contains("amazon"))
		{
			System.out.println("Pass -- Correct URL");
		}
		else
		{
			System.out.println("Fail -- Incorrect URL");
		}
		browserUtil.quitBrowser();
	}
}
