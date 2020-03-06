package undostres.com.pruba.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.qameta.allure.Step;
import undostres.com.pruba.utils.CommonFactory;
import undostres.com.pruba.utils.Config.Locator;
import undostres.com.pruba.utils.ElementUtils;

public class RechargeCellularPage {
	
	
@FindBy(how=How.CSS,using="[do='mobile']")
private WebElement mobilerechargePage;

@FindBy(how=How.CSS,using="[to-do='mobile'] [name='operator']")
private WebElement operatorField;

@FindBy(how=How.CSS,using="[to-do='mobile'] [name='mobile']")
public  WebElement mobileNumberField;

@FindBy(how=How.CSS,using="[to-do='mobile'] [name='amount']")
private WebElement amountField;

@FindBy(how=How.CSS,using="[to-do=\"mobile\"] button[perform=\"payment\"]")
private WebElement rechargeButton;




public RechargeCellularPage()
{
	CommonFactory.initliseElement(this);
}
@Step("Select Operator")
public void selectOperator(String operatorName)
{
	CommonFactory.clickElement(operatorField);
	CommonFactory.clickObject(ElementUtils.getElement(Locator.CSS, "[to-do='mobile'] [name='operator'] ~.suggestion [data-show='"+operatorName+"']>a"));
}

@Step("Select recharge")
public void selectRecharge(String rechargeValue)
{
	CommonFactory.clickElement(amountField);
	CommonFactory.clickElement(ElementUtils.getElement(Locator.CSS, "[name='amount'] ~.suggestion [data-name='"+rechargeValue+"']"));
}
@Step("Click on Recharge Button")
public void clickOnRechargeButton()
{
	CommonFactory.clickElement(rechargeButton);
}




}
