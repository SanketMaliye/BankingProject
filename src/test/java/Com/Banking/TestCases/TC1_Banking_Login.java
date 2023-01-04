package Com.Banking.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Banking.BaseClass.Banking_BaseClass;
import Com.Banking.PageObject.Banking_LoginPage;

public class TC1_Banking_Login extends Banking_BaseClass{

	@Test
	public void LoginTest() throws IOException {
		log.info("Open Browser.");
		Banking_LoginPage BL=new Banking_LoginPage();
		
		BL.SetUsername(username);
		log.info("Enter Username.");
		BL.SetPassword(Password);
		log.info("Enter Password.");
		BL.Login();
		log.info("Click On Login Button.");
		
		@SuppressWarnings("unused")
		boolean msg=driver.findElement(By.xpath("//td[text()=\"Manger Id : mngr463946\"]")).isDisplayed();
		if(msg=true) {
			Assert.assertTrue(true);
			log.info("Test case passed");		
		}
		else {
			TakeSS("Login Test Case.");
			Assert.assertTrue(false);
			log.info("Test case failed");

		}
	}
}
