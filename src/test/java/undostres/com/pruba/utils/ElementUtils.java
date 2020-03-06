package undostres.com.pruba.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementUtils {

	
	/*
	 *  For handling the dynamic elements
	 */
	
	public static  WebElement getElement(Config.Locator locator,String locatorValue)
	{
		WebElement returnElement=null;
		switch(locator)
		{
		case CSS:
		    returnElement= DriverManager.getDriver().findElement(By.cssSelector(locatorValue));
			break;
		case ID:
			returnElement= DriverManager.getDriver().findElement(By.id(locatorValue));
			break;
		case LINK:
			returnElement= DriverManager.getDriver().findElement(By.linkText(locatorValue));
			break;
		case NAME:
			returnElement= DriverManager.getDriver().findElement(By.name(locatorValue));
			break;
		case XPATH:
			returnElement= DriverManager.getDriver().findElement(By.xpath(locatorValue));
			break;
		case XPATH_TEXT:
			returnElement= DriverManager.getDriver().findElement(By.xpath("//*[. = '"+locatorValue+"']"));
			break;
		case XPATH_DIV_CONTAINS_TEXT:
			returnElement= DriverManager.getDriver().findElement(By.xpath("//div[contains(text(), '"+locatorValue+"']"));
			break;
		case XPATH_SPAN_CONTAINS_TEXT:
			returnElement= DriverManager.getDriver().findElement(By.xpath("//span[contains(text(), '"+locatorValue+"']"));
			break;
		case XPATH_CONTAINS_TEXT:
			returnElement= DriverManager.getDriver().findElement(By.xpath("//*[contains(text(), '"+locatorValue+"']"));
			break;
		default:
			break;
		}
		
		return returnElement;
	}

}
