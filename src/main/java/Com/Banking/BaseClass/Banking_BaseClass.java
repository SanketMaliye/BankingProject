package Com.Banking.BaseClass;

 
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.Banking.Configurations.ReadConfiguration;
import Com.Banking.Utilities.Banking_TestUtils;
import net.bytebuddy.utility.RandomString;

 
public class Banking_BaseClass {
	
    ReadConfiguration readconfig = new ReadConfiguration();
	
	String URL=readconfig.getAppUrl();
	protected String username=readconfig.getUsername();
	protected String Password=readconfig.getPassword();
	String CHROMEPATH=readconfig.getChromePath();
	String FIREFOXPATH=readconfig.getFirefoxPath();
	
	public static WebDriver driver;
	public static Logger log;
	
	@SuppressWarnings("deprecation")
	@Parameters("Browser")
	@BeforeMethod
	public void initialization(String browser) throws InterruptedException  {
		
		
		log=Logger.getLogger("Banking_Log");
		PropertyConfigurator.configure("log4j.properties");
		
//		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Banking_TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(Banking_TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
//		String url="https://demo.guru99.com/V1/index.php";
		
		driver.get(URL);
	}
	
	public String TakeSS(String TestCaseName) throws IOException {

		TakesScreenshot Ts = (TakesScreenshot) driver;
		File Source = Ts.getScreenshotAs(OutputType.FILE);
		String Random = RandomString.make(5);
		String Destination = System.getProperty("user.dir") + "/Screenshots/" + TestCaseName + " " + Random + ".png";
		FileUtils.copyFile(Source, new File(Destination));
		return Destination;
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}
