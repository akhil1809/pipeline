package undostres.com.pruba.utils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class Factory {
		
    
	
	public static String platFormName;
	public static String browserName;
	
	
	@BeforeTest(groups= {"regression"})
	@Parameters({"browserName","platFormName","url"})
    public void setup(String browserName,String platFormName,String url)
    {
		
        Factory.platFormName=platFormName;
        Factory.browserName=browserName;
        DriverManager.setBrowserName(browserName);
		BrowserFactory.openBrowser(Config.BROWSER.valueOf(Factory.browserName));	
		DriverManager.getDriver().get(url);
    }

	@AfterTest(groups= {"regression"})
	@Parameters({"platFormName"})
	public void endSetup()
    {

		DriverManager.getDriver().close();
       
		DriverManager.getDriver().quit();

    }


}
