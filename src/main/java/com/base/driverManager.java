package com.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.utility.utility;

public class driverManager {
	private static driverManager driverManagerClass;
	private static WebDriver driver=null;;
	private static  ThreadLocal<WebDriver> webDriver=new ThreadLocal<WebDriver>();

	private driverManager()
	{
		
	}
	
	public static driverManager getWebDriverManager()
	{
		if(driverManagerClass==null)
		{
			driverManagerClass=new driverManager();	

		}
		return driverManagerClass;

		
	}
	
	public static WebDriver getDriver() throws IOException
	{
		if(driver==null)
		{            
        switch (utility.readProperties("browser").toLowerCase()) {
        
        case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver=new ChromeDriver(options);
			//driver=new InternetExplorerDriver();
			//driver=new EdgeDriver();
			webDriver.set(driver);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
			
        case "firefox":
        	  FirefoxOptions foptions=new FirefoxOptions();
  			foptions.addArguments("--incognito");
  			driver=new FirefoxDriver(foptions);
  			webDriver.set(driver);
  			driver.manage().window().maximize();
  			driver.manage().deleteAllCookies();
  			break;
        case "Edge":
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--incognito");
  			driver=new EdgeDriver(edgeOptions);
  			webDriver.set(driver);
  			driver.manage().window().maximize();
  			driver.manage().deleteAllCookies();
        	  
        	  
			
        }
			
			
			

		}
		
		return driver;
		
	}

	 public static void resetDriverManagerInstance() {
		 driverManagerClass = null;
	        driver=null;
	    }



}
