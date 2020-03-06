package undostres.com.pruba.tests;


import org.testng.Assert;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import undostres.com.pruba.utils.CommonFactory;
import undostres.com.pruba.utils.DriverManager;
import undostres.com.pruba.utils.TestData;

public class RechargeTest {

	
	
	@Test(priority= 1,groups= {"regression"})
	@Description("Verify to check Payemnt Page displayed")
	@Severity(SeverityLevel.CRITICAL)
	public void verfiyPaymentPageWithTelcelOperator()
	{
		try
		{
			DriverManager.getRechargePage().selectOperator(TestData.getOperator().get(1));
			CommonFactory.enterText("5523261151", DriverManager.getRechargePage().mobileNumberField);
			DriverManager.getRechargePage().selectRecharge(TestData.getRechargeCode().get(10));
			DriverManager.getRechargePage().clickOnRechargeButton();	
			Assert.assertTrue(CommonFactory.isDisplayed(DriverManager.getPayementPage().paymentOption));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
			Assert.fail("test case failed");
		}
		
	}

}
