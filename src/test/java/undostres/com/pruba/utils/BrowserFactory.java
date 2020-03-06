package undostres.com.pruba.utils;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

public class BrowserFactory {

	public static WebDriver webDriver;

    public static  void openBrowser(Config.BROWSER browser)
    {
        
    	 switch (browser)
         {
             case CHROME:
                 System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
                 ChromeOptions options=new ChromeOptions();
                 options.setExperimentalOption("useAutomationExtension", false);
                 options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                 webDriver=new ChromeDriver(options);
                 DriverManager.setDriver(webDriver);
                 
                 break;

             case FIREFOX:
                 System.setProperty("webdriver.gecko.driver","./drivers/geckodriver");
                 FirefoxOptions firefoxOptions=new FirefoxOptions();
                 firefoxOptions.addArguments("--start-maximized");
                 webDriver=new FirefoxDriver();
                 DriverManager.setDriver(webDriver);
                 break;

             case SAFARI:
                 webDriver=new SafariDriver();
                 DriverManager.setDriver(webDriver);
                 break;

             default:
             	Assert.fail("No Browser Found");
                 webDriver=null;
             	break;
         }
    	 webDriver.manage().deleteAllCookies();
    	 CommonFactory.maxmizeBrowserWindows();
    }
        

}
