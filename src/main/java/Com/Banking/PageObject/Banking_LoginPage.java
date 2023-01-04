package Com.Banking.PageObject;

 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Banking.BaseClass.Banking_BaseClass;

public class Banking_LoginPage extends Banking_BaseClass {
 
	@FindBy(name="uid")
	public WebElement Username;
	@FindBy(name="password")
	public WebElement Password;
	@FindBy(name="btnLogin")
	public WebElement Login;
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	public WebElement LogoutBtn;
	
	public Banking_LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void SetUsername(String U) {
		Username.sendKeys(U);
	}
	public void SetPassword(String P) {
		Password.sendKeys(P);
	}
	public void Login() {
		Login.click();
	}
	public void LogoutButton() {
		LogoutBtn.click();
	}
}
