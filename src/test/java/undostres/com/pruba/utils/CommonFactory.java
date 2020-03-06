package undostres.com.pruba.utils;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFactory {

	
	private static Wait<WebDriver> fluentWait;
	private static WebElement fluentWaitElement;
	final private static int TIMEOUT_IN_SECONDS = 15;
	final private static int POLLING_TIME_IN_SECONDS = 1;
	public static  Actions action=new Actions(DriverManager.getDriver());
	public static String failedWebTestScreenshotLocation = "./screenshot/failed_Test";
	public static JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();;
	
	 public static void initliseElement(Object object)
	 {
		 PageFactory.initElements(BrowserFactory.webDriver,object);
	 }
	
	
	public static void maxmizeBrowserWindows()
	{
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		int width=(int) toolkit.getScreenSize().getWidth();
		int height=(int) toolkit.getScreenSize().getHeight();
        BrowserFactory.webDriver.manage().window().setSize(new Dimension(width, height));
	}

//##################### Element Displayed Functions ######################//


    public static  boolean isDisplayed(WebElement element)
    {
        try
        {
                WebDriverWait wait = new WebDriverWait(BrowserFactory.webDriver, 30);
                wait.until(ExpectedConditions.visibilityOf(element));
                return  true;

        }
        catch(NoSuchElementException e)
        {
            e.printStackTrace();
            return  false;
        }

    }

    public boolean elementDisplayed(WebElement element)
    {
        try
        {
            return element.isDisplayed();
        }
        catch (Exception err)
        {
            err.printStackTrace();
            return  false;
        }
    }

    public static boolean isDisplayed(int timeoutInSeconds, int pollingTimeInSeconds, WebElement element)
   	{
   		try
   		{
   			if(timeoutInSeconds == 0)
   				timeoutInSeconds = TIMEOUT_IN_SECONDS;
   			if(pollingTimeInSeconds == 0)
   				pollingTimeInSeconds = POLLING_TIME_IN_SECONDS;
   			
   				fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
   						.pollingEvery(Duration.ofSeconds(pollingTimeInSeconds))
   						.withTimeout(Duration.ofSeconds(timeoutInSeconds))
   							.ignoring(NoSuchElementException.class, Error.class);
   			
   			fluentWaitElement = element;
   			return fluentWait.until ( new Function<WebDriver, Boolean>() 
   			{
   				public Boolean apply(WebDriver driver)
   				{
   					return fluentWaitElement.isDisplayed();
   				}
   			}
   		);
   		}
   		catch(Throwable e)
   		{
   			e.printStackTrace();
   			return false;
   		}
   	}


//##################### Click Functions #####################//


    public static void clickElement(WebElement element)
    {
       try
       {
           if(isDisplayed(element))
           {
               WebDriverWait wait = new WebDriverWait(BrowserFactory.webDriver, 30);
               wait.until(ExpectedConditions.elementToBeClickable(element));
               element.click();
           }
       }

       catch (NoSuchElementException e)
       {
           e.printStackTrace();

       }
    }
    
    public static void clickObject(WebElement element)
	{
		try 
		{
			
			executor.executeScript("arguments[0].click();", element);
		}
		
		catch (NoSuchElementException e)
        {
			e.printStackTrace();	
        }
	}
    
    public static void getScreenShot(String failedWebTestScreenshotLocation)
   	{
   		try 
   		{
   			File srcFile=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
   			FileUtils.copyFile(srcFile, new File(failedWebTestScreenshotLocation));
   		} 
   		catch (IOException e) 
   		{
   			e.printStackTrace();
   		}
   	}

    public static String getCurrentTimeStamp()
   	{
       	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
   		return simpleDateFormat.format(new Date());
   	}
    
    
    public static void wait(int time)
    {
    	try
    	{
    		Thread.sleep(time*1000);
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    /********Enter Text*********/
    
    public static void  enterText(String attributesName,WebElement element)
    {
    	try
    	{
    		if(isDisplayed(element))
            {
                WebDriverWait wait = new WebDriverWait(BrowserFactory.webDriver, 30);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.sendKeys(attributesName);
            }
    		 
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    
    /******** Switch to frame ********/
    public static void switchToFrame(WebElement element )
    
    {
    	DriverManager.getDriver().switchTo().frame(element);
    }
    
   public static void switchToDefault()
    
    {
    	DriverManager.getDriver().switchTo().defaultContent();
    }
    
    
}
