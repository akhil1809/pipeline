package undostres.com.pruba.utils;

import org.openqa.selenium.WebDriver;

import undostres.com.pruba.pages.PaymentPage;
import undostres.com.pruba.pages.RechargeCellularPage;

public class DriverManager {
	
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> browserName = new ThreadLocal<String>();
	private static PaymentPage payment ;
	private static RechargeCellularPage recharge;

	
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverObject) {
		driver.set(driverObject);
	}
	
	public static String getBrowserName() {
		return browserName.get();
	}

	public static void setBrowserName(String name) {
		browserName.set(name);
	}
	
	public static PaymentPage getPayementPage()
	{
		if(payment==null)
			payment=new PaymentPage();
		return payment;
	
	}
	
	public static RechargeCellularPage getRechargePage()
	{
		if(recharge==null)
			recharge=new RechargeCellularPage();
		return recharge;
	
	}
	
}
