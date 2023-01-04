package Com.Banking.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Banking.BaseClass.Banking_BaseClass;

public class Banking_NewCustomerPage extends Banking_BaseClass {
//	1.
	@FindBy(xpath="//a[text()=\"New Customer\"]") public WebElement NewCust;
	@FindBy(xpath="//span[text()=\"Close\"]") public WebElement dismiss;
	@FindBy(name="name") public WebElement CName;
	@FindBy(name="rad1") public WebElement Male;
	@FindBy(name="dob") public WebElement DOB;
	@FindBy(name="addr") public WebElement Address;
	@FindBy(name="city") public WebElement City;
	@FindBy(name="state") public WebElement State;
	@FindBy(name="pinno") public WebElement Pin;
	@FindBy(name="telephoneno") public WebElement TP;
	@FindBy(name="emailid") public WebElement Email;
	@FindBy(name="password") public WebElement Pass;
	@FindBy(name="sub") public WebElement Submit;

//	2.
	public Banking_NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
//	3.
	public void NewCustomer() throws InterruptedException {
		NewCust.click();
		Thread.sleep(4000);
	}
	public void DM()
	{
		dismiss.click();
	}
	public void SetCustomerName(String CN) {
		CName.sendKeys(CN);
	}
	public void Gender() {
		Male.click();
	}
	public void SetDOB(String dob) {
		DOB.sendKeys(dob);
	}
 	public void SetAddress(String add) {
 		Address.sendKeys(add);
 	}
 	public void SetCity(String C) {
 		City.sendKeys(C);
 	}
 	public void SetState(String S) {
 		State.sendKeys(S);
 	}
 	public void SetPin(String P) {
 		Pin.sendKeys(P);
 	}
 	public void SetTP(String tp) {
 		TP.sendKeys(tp);
 	}
 	public void SetEmail(String E) {
 		Email.sendKeys(E);
 	}
 	public void SetPass(String Pa) {
 		Pass.sendKeys(Pa);
 	}
 	public void Submit() {
 		Submit.click();
 	}
 
}
