package com.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.utility;

public class baseClass{
	public WebDriver driver=null;
	public  String UserName ="";
	public  String url ="";	
	public String urlSeleniumScearios="";
	public String urlExcelScenario="";
	public String urlMyntraScenario="";
	public String urlMyntraScenarioShirts="";


	public String parentwindow="";
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentTest;
    public String WdomainName="testingRTPAuto2";
    public String webPageName="testing";
    public String path="C:\\Users\\tirumalabhara.godav\\Downloads\\MyHomePage.zip";
   

	
	public baseClass() throws IOException
	{
        htmlReporter = new ExtentHtmlReporter("extentReports.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        String browser=System.getProperty("browser");
		driver=driverManager.getWebDriverManager().getDriver();
		UserName=utility.readProperties("username");
		url=utility.readProperties("url");
		urlSeleniumScearios=utility.readProperties("url1");
		urlExcelScenario=utility.readProperties("url2");
		urlMyntraScenario=utility.readProperties("url3");
		urlMyntraScenarioShirts=utility.readProperties("url4");

				
	}
	
	public void launchBrowser() throws IOException
	{
        if(utility.readProperties("application").equalsIgnoreCase("RTP"))
        {
	   driver.manage().window().maximize();
	   driver.navigate().to(url);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }else if(utility.readProperties("application").equalsIgnoreCase("SeleniumScenarios"))
        {
        	 driver.manage().window().maximize();
      	   driver.navigate().to(urlSeleniumScearios);
      	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        	
        }
        else if(utility.readProperties("application").equalsIgnoreCase("excel"))
        {
        	 driver.manage().window().maximize();
      	   driver.navigate().to(urlExcelScenario);
      	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        	
        }else if(utility.readProperties("application").equalsIgnoreCase("myntra"))
        {
        	 driver.manage().window().maximize();
        	   driver.navigate().to(urlMyntraScenario);
        	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        	
        }else if(utility.readProperties("application").equalsIgnoreCase("myntrashirts"))
        {
       	 driver.manage().window().maximize();
       	   driver.navigate().to(urlMyntraScenarioShirts);
       	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       	
       }
	}
	
	
    public void flushReports() {
        extentReports.flush(); // Flush the reports at the end
    }


}
