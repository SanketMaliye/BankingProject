package Com.Banking.TestCases;

 
//import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Banking.BaseClass.Banking_BaseClass;
import Com.Banking.PageObject.Banking_LoginPage;
import Com.Banking.PageObject.Banking_NewCustomerPage;
import net.bytebuddy.utility.RandomString;
 

public class TC2_Banking_NewCustomer extends Banking_BaseClass{

 
	@SuppressWarnings("unused")
	@Test
	public void NewCustmer() throws InterruptedException {
		Banking_NewCustomerPage BNC = new Banking_NewCustomerPage();
		
//		Banking_LoginTC LC=new Banking_LoginTC();
//		LC.LoginTest();
		
		log.info("Open Browser.");
		Banking_LoginPage BL=new Banking_LoginPage();
		
		BL.SetUsername(username);
		log.info("Enter Username.");
		BL.SetPassword(Password);
		log.info("Enter Password.");
		BL.Login();
		log.info("Click On Login Button.");
		
		Thread.sleep(4000);
		BNC.NewCustomer();
		log.info("Clicking On New Customer Link.");
		driver.navigate().refresh();
		Thread.sleep(3000);
		BNC.NewCustomer();
		BNC.SetCustomerName("James");
		log.info("Setting the Customer Name.");
		BNC.Gender();
		log.info("Gender Male Button Click");
		BNC.SetDOB("07/03/1998");
		log.info("Setting the DOB");
		BNC.SetAddress("Gayatri Nagar Telhara");
		log.info("Setting the Address");
		BNC.SetCity("Telhara");
		log.info("Setting the City");
		BNC.SetState("Maharashtra");
		log.info("Setting the State");
		BNC.SetPin("444108");
		log.info("Setting the Pin");
		BNC.SetTP("1234567");
		log.info("Setting the Telephone");
		
		String random=RandomString.make(10);
		String Email=random+"@gmail.com";
		
//		BNC.SetEmail("smaliye54@gmail.com");
		BNC.SetEmail(Email);
		log.info("Setting the Email");
		BNC.SetPass("Sanket@123"); 
		log.info("Setting the Password.");
	 	BNC.Submit(); 
	 	log.info("Clicking Submit");
	 	 
	 	boolean test1=driver.findElement(By.xpath("//p[text()=\"Customer Registered Successfully!!!\"]")).isDisplayed(); 
	 	if(test1=true) {
	 		Assert.assertTrue(true);
	 		log.info("ID Created.");
	 	}
	 	else {
	 		Assert.assertTrue(false);
	 		log.info("ID is Not Created.");
	 	}
	}
	
}
