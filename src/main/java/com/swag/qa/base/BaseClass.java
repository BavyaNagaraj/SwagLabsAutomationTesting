package com.swag.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.swag.qa.utility.UtilClass;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		
		prop = new Properties();
		
		try {
			
			FileInputStream fis = new FileInputStream("D:\\Eclipse\\Bavya_Workspace\\SwagLabsAutomation\\src\\"
					+ "main\\java\\com\\swag\\qa\\config\\config.properties");
			
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.getProperty("user dir");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.getProperty("user dir");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")){
			System.getProperty("user dir");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equals("safari")) {
			System.getProperty("user dir");
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilClass.page_Load_TimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilClass.implicitly_Wait));
		
		driver.get(prop.getProperty("url"));
		
	}

}
