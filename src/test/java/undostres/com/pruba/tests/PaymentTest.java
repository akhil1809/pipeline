package undostres.com.pruba.tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import junit.framework.Assert;
import undostres.com.pruba.utils.DriverManager;
import undostres.com.pruba.utils.TestData.CARDINFO;
import undostres.com.pruba.utils.TestData.MESSAGE;



public class PaymentTest {

/*
 * 
 * IN this i am unable to go on recharge successful page, so i written negative scenario 
 * 
 * 
 */
	
	@Test(priority= 2,groups= {"regression"})
	@Description("Verify to check recharge sucessfull or not")
	@Severity(SeverityLevel.CRITICAL)
	public void verfiyPaymentSuccessfull()
	{
		try
		{
			DriverManager.getPayementPage().enterCardDetail(CARDINFO.CARDHOLDER.getCardInfo(), CARDINFO.VISA.getCardInfo(), CARDINFO.MONTH.getCardInfo(),CARDINFO.YEAR.getCardInfo(), CARDINFO.CVV.getCardInfo());
			DriverManager.getPayementPage().enterEmail(CARDINFO.EMAIL.getCardInfo());
			DriverManager.getPayementPage().clickOnPayWithCardButton();
			DriverManager.getPayementPage().enterLoginDetials(CARDINFO.EMAIL2.getCardInfo(), CARDINFO.PASSWORD.getCardInfo());
			Assert.assertTrue(DriverManager.getPayementPage().verifySuccessMessage(MESSAGE.INVALIDLOGIN.getMessageInfo()));
			DriverManager.getPayementPage().closeLoginWindow();
		}
		catch(Exception e)
		{
			
			DriverManager.getPayementPage().closeLoginWindow();
			e.printStackTrace();
			e.getMessage();
			Assert.fail("Test Failed");
		}
		
	}
}
