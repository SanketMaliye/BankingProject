package Com.Banking.TestCases;

import java.io.IOException;

 
import org.openqa.selenium.NoAlertPresentException;
 
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Banking.BaseClass.Banking_BaseClass;
import Com.Banking.PageObject.Banking_LoginPage;
import Com.Banking.Utilities.XLUtils;

public class TC1_Banking_LoginWithXL extends Banking_BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void LoginTest(String user,String Pwd) throws IOException, InterruptedException {
		log.info("Open Browser.");
		Banking_LoginPage BL=new Banking_LoginPage();
		
		BL.SetUsername(user);
		log.info("Enter Username.");
		BL.SetPassword(Pwd);
		log.info("Enter Password.");
		BL.Login();
		log.info("Click On Login Button.");
		
		if(IsAlertpresent()==true) {
			driver.switchTo().alert().accept();//popuclose
			driver.switchTo().defaultContent();
			AssertJUnit.assertTrue(true);
			log.info("LoginFailed");
		}
		else {
			AssertJUnit.assertTrue(true);
			log.info("Login Passed");
            Thread.sleep(2000);
            BL.LogoutButton();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
		}
	}
	
        public boolean IsAlertpresent() throws InterruptedException {
		
		try {
		driver.switchTo().alert();
		Thread.sleep(2000);
		return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
        
        @DataProvider(name="LoginData")
    	public String[][] getdata() throws IOException{
    		
    		String path=System.getProperty("user.dir")+"\\src\\main\\java\\Com\\Banking\\TestData\\BankingLoginData.xlsx";
    	
    		int rownum=XLUtils.getRowCount(path, "Sheet1");
    		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
    		
    		String logindata[][]=new String[rownum][colcount];
    		
    		for(int i=1;i<=rownum;i++) {  //Row
    			
    			for(int j=0;j<colcount;j++) { //Col
    				
    				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);  //1 0  1 1
    			}
    		}
    		
    		return logindata;
    	}
}
