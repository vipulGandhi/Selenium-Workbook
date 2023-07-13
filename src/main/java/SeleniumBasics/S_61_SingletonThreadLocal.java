package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_61_SingletonThreadLocal
{
    // ThreadLocal used to manage the driver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Private constructor to prevent the creation of new instances of Driver
    private S_61_SingletonThreadLocal()
    {
    }

    // Public method to access the driver instance (uses lazy instantiation)
    public static WebDriver getInstance()
    {
        if (driver.get() == null)
        {
            driver.set(new ChromeDriver());
        }

        return driver.get();
    }

/*
Public method to quit the driver and 
remove the current thread's value for this thread-local variable
*/
    public static void quit()
    {
        driver.get().quit();
        driver.remove();
    }
}
