package SeleniumBasics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_64_VerifyBrokenLinks
{
	public static void main(String[] args) throws ClientProtocolException, IOException	
	{		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.softwaretestingmaterial.com");
		
		List<WebElement> allLinkElements = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinkElements.size());
		
		for (WebElement webElement : allLinkElements)
		{
			HttpClient client = HttpClientBuilder.create().build();
	        HttpGet request = new HttpGet(webElement.getAttribute("href"));
	        HttpResponse response = client.execute(request);

	        if (response.getStatusLine().getStatusCode() != 200)
	        {
	        	System.out.println(webElement.getAttribute("outerHTML") + " is broken.");
	        }
		}
		driver.quit();
	}
}
