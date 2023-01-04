package Com.Banking.Configurations;

import java.io.File;
import java.io.FileInputStream;
 
 
import java.util.Properties;

public class ReadConfiguration {

	Properties pro;
	
	public ReadConfiguration()  {
		
		String path="C:\\Users\\SHREE\\eclipse-workspace\\Banking\\src\\main\\java\\Com\\Banking\\Configurations\\Config.properties";
		
		File src=new File(path);
		
		FileInputStream fis;
		
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
		}
					
		}
	 
	
	public String getAppUrl() {
		String url=pro.getProperty("baseURl");
		return url;
	}
	
	public String getUsername() {
		String User=pro.getProperty("username");
		return User;
	}
	
	public String getPassword() {
		String Pass=pro.getProperty("password");
		return Pass;
	}
	
	public String getChromePath() {
		String Chromepath=pro.getProperty("chromepath");
		return Chromepath;
	}
	
	public String getFirefoxPath() {
		String Firefoxpath=pro.getProperty("firefoxpath");
		return Firefoxpath;
	}
}
