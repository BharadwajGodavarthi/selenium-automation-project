package com.pageclasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;
import com.utility.utility;

public class rtpWebDomainPage  extends baseClass{
	
	

	@FindBy(xpath="//*[@aria-label='Web Domains']")
	private WebElement rtpWebDomains;
	@FindBy(xpath="//*[text()='ADD WEB PAGE']")
	private WebElement addWebPage;
	@FindBy(xpath="//input[@name='file_name']")
	private WebElement webPageFileName;
	@FindBy(xpath="//*[text()='BROWSE']")
	private WebElement webPageUploadButton;
	@FindBy(xpath="//input[@name='page_name']")
	private WebElement webPagePageName;
	@FindBy(xpath="//button[text()='Add']")
	private WebElement webPageAdd;
	@FindBy(xpath="//div/button[@type='button']")
	private WebElement clickNewDomain;
	@FindBy(xpath="//input[@name='domain_name']")
	private WebElement domainName;
	@FindBy(xpath="//div/button[@text='Add']")
	private WebElement savedomain;
	
   
	
	@FindBy(xpath="//*[contains(@placeholder,'Search')]")
	private WebElement searchInput;
	
	@FindBy(xpath="//legend/span[text()='name']")
	private WebElement searchName;
	
	public rtpWebDomainPage() throws IOException {
		super();
		PageFactory.initElements(driver,this);

		// TODO Auto-generated constructor stub
	}
	
	public void webDomainTab()
	{
		utility.explicitWaitOfElement(30, driver, rtpWebDomains);
		rtpWebDomains.click();	
		
	}
	
	public void createwebDomainTab()
	{
		utility.explicitWaitOfElement(30, driver, rtpWebDomains);
		clickNewDomain.click();	
		utility.explicitWaitOfElement(30, driver, domainName);
		domainName.sendKeys(WdomainName);
		savedomain.click();
		
	}
	
	public void searchWebDomain()
	{
		try
		{
		utility.explicitWaitOfElement(30, driver, rtpWebDomains);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='"+ WdomainName +"']")));
        driver.findElement(By.xpath("//*[text()='"+ WdomainName +"']")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void createWebPageinWebDomain()
	{
		try
		{
		utility.explicitWaitOfElement(30, driver, addWebPage);
		addWebPage.click();
		utility.explicitWaitOfElement(30, driver, webPageFileName);
		webPageUploadButton.click();
		utility.uploadFile();
		webPagePageName.sendKeys(webPageName);
		webPageAdd.click();
		
		
        
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	

	public void clickeWebPageinWebDomain()
	{
		try
		{
			 driver.findElement(By.xpath("//*[text()='"+ webPageName +"']")).click();
		
		
        
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	

}
