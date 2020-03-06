package undostres.com.pruba.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.qameta.allure.Step;
import undostres.com.pruba.utils.CommonFactory;

import undostres.com.pruba.utils.TestData.MESSAGE;
import undostres.com.pruba.utils.TestData.PAYEMENTOPTION;

public class PaymentPage {

	
	
	@FindBy(how=How.CSS,using=".container-all-payment-options")
	public WebElement paymentOption;
	
	@FindBy(how=How.CSS,using=".card-info-box [name='cardname']")
	public WebElement cardName;
	
	@FindBy(how=How.CSS,using=".card-info-box [name='cardno']")
	public WebElement cardNumber;
	
	@FindBy(how=How.CSS,using=".card-info-box [name='expmonth']")
	public WebElement expMonth;
	
	@FindBy(how=How.CSS,using=".card-info-box [name='expyear']")
	public WebElement expYear;
	
	@FindBy(how=How.CSS,using=".card-info-box [name='cvvno']")
	public WebElement cvvNumber;
	
	@FindBy(how=How.CSS,using="#card_save_block~#email_block [name='txtEmail']")
	public WebElement email;
	
	@FindBy(how=How.CSS,using="[name='formsubmit']")
	private WebElement payWithButton;
	
	@FindBy(how=How.CSS,using="#usrname")
	public WebElement username;
	
	@FindBy(how=How.CSS,using="#psw")
	private WebElement password;
	
	@FindBy(how=How.CSS,using="[role='checkbox'] .recaptcha-checkbox-border")
	private WebElement captchaCheckBox;
	
	@FindBy(how=How.CSS,using="[name=\"loginbtn\"]")
	private WebElement acessButton;
	
	@FindBy(how=How.CSS,using="#login [data-dismiss='modal']")
	private WebElement closeButton;
	
	@FindBy(how=How.CSS,using=".tab-pane #add_err")
	private WebElement errMessage;
	
	@FindBy(how=How.CSS,using="[role=\"presentation\"] ")
	private WebElement captchaFrameID;
	
	@FindBy(how=How.CSS,using=".container-all-payment-options .select-wallet")
	private WebElement walletOption;
	
	@FindBy(how=How.CSS,using=".container-all-payment-options .select-card")
	private WebElement cardOption;
	
	@FindBy(how=How.CSS,using=".container-all-payment-options .select-paypal")
	private WebElement paypalOption;
	
	@FindBy(how=How.CSS,using=".container-all-payment-options .select-stp")
	private WebElement stpOption;
	
	
	
	
	
	public PaymentPage()
	{
		CommonFactory.initliseElement(this);
	}
	
	@Step("Enter the Card Details")
	public void enterCardDetail(String cardAccountHolder, String number,String month,String year,String cvv)
	{
		CommonFactory.enterText(cardAccountHolder, cardName);
		CommonFactory.enterText(number, cardNumber);
		CommonFactory.enterText(month, expMonth);
		CommonFactory.enterText(year, expYear);
		CommonFactory.enterText(cvv, cvvNumber);	
	}
	@Step("Enter the User Email")
	public void enterEmail(String custEmail)
	{
		CommonFactory.enterText(custEmail, email);
	}
	
	@Step("Click on PayWithCardButton")
	public void clickOnPayWithCardButton()
	{
		CommonFactory.clickElement(payWithButton);
	}
	
	@Step("Enter the valid loginCredential")
	public void enterLoginDetials(String login,String loginPassword)
	{
		CommonFactory.enterText(login, username);
		CommonFactory.enterText(loginPassword, password);
		goToCapthca();
		
		CommonFactory.clickElement(acessButton);
	}
	
	@Step("Close login popup")
	public void closeLoginWindow()
	{
		CommonFactory.clickObject(closeButton);
	}
	
	@Step("Verify Sucess message")
	public boolean verifySuccessMessage(String errMessage)
	{
		boolean messageStaus=false;
		
		if(errMessage.equals(MESSAGE.INVALIDLOGIN.getMessageInfo()))	
		{
			System.out.println("Recharge Unsuccesfull");
			closeLoginWindow();
			return messageStaus;
		}
		else
		{
			System.out.println("Recharge Successfull");
			return messageStaus;
		}
	}
	
	@Step("Go to captch")
	public void goToCapthca()
	{
		CommonFactory.wait(2);
		CommonFactory.switchToFrame(captchaFrameID);
		CommonFactory.wait(2);
		CommonFactory.clickElement(captchaCheckBox);
		CommonFactory.wait(2);
		CommonFactory.switchToDefault();
	}
	
	public void selectPayementOption(PAYEMENTOPTION paymentOption)
	{
		switch(paymentOption)
		{
		case CARD:
			CommonFactory.clickElement(cardOption);
			break;
		case COINPURSE:
			CommonFactory.clickElement(walletOption);
			break;
		case PAYPAL:
			CommonFactory.clickElement(paypalOption);
			break;
		case SPEI:
			CommonFactory.clickElement(stpOption);
			break;
		default:
			break;
			
		}
	}
	
}
