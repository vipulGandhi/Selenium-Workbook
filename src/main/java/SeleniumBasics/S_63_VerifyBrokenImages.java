// Method - 1
	// Use the <img> tag to collect details of the images present on the page
	// For each <img> tag, get the attribute <src>
	// Convert the path obtained from the <src> attribute to an ‘Absolute Path.
		// Not required for Selenium Java, Selenium C#, Selenium Python
		// Required for Selenium PHP
	// Send an HTTP request to the image link and capture the response code received in response to the request.
	// Based on the response code, validate whether the image is broken

// Method - 2
	// "naturalWidth" attribute returns the original width of the image
		// It's value is 0 for a broken image

package SeleniumBasics;

import java.io.IOException;
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


public class S_63_VerifyBrokenImages
{
	public static void main(String[] args) throws ClientProtocolException, IOException
	{		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/broken_images");
		
		int brokenImagesCount = 0;
		
		List<WebElement> imageElementsOnPage = driver.findElements(By.tagName("img"));
		
		// Method - 01
		for (WebElement webElement : imageElementsOnPage)
		{
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(webElement.getAttribute("src"));
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200)
            {
                System.out.println(webElement.getAttribute("outerHTML") + " is broken.");
                brokenImagesCount++;
            }
		}
		
		System.out.println("-------");
		
		// Method - 02
		for (WebElement webElement : imageElementsOnPage)
		{
            if (webElement.getAttribute("naturalWidth").equals("0"))
            {
                System.out.println(webElement.getAttribute("outerHTML") + " is broken.");
                brokenImagesCount++;
            }
		}
	}
}
