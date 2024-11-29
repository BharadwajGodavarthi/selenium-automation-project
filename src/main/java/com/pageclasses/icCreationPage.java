package com.pageclasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.baseClass;
import com.utility.utility;

public class icCreationPage extends baseClass {

	

	@FindBy(xpath="//*[text()='Interact']")
	private WebElement interactIcon;
	
	@FindBy(xpath="//*[contains(text(),'Interactive channels')]")
	private WebElement interactiveChannels;
	
	@FindBy(xpath="//*[contains(text(),'Add interactive channel')]")
	private WebElement addInteractiveChannel;

	@FindBy(xpath="//iframe[@id='contentframe']")
	private WebElement addICPageFrame;
	
	@FindBy(xpath="//iframe[@id='RSIFrameID_movWindow_1']")
	private WebElement addICPageFrameIC;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement icName;
	
	@FindBy(xpath="//div[text()='Select a policy']")
	private WebElement ICSelectPolicy;
	
	@FindBy(xpath="//div[text()='Select a policy']/following::li/a[text()='Global Policy']")
	private WebElement icSecurityPolicy;
	
	@FindBy(xpath="//select[@id='serverGroups']")
	private WebElement icRTServerGroup;
	
	@FindBy(xpath="//span[text()='Save and return']")
	private WebElement icSaveandReturn;
	
	@FindBy(xpath="//*[text()='InteractRTP']")
	private WebElement icRTPNavigation;
	
	@FindBy(xpath="//*[text()='Dashboard']")
	private WebElement RTPDashboard;
	
	private By RTPDashboardPage=By.xpath("//*[text()='Dashboard']");
	
	private By interactiveChannelsHomePage= By.xpath("//*[text()='All interactive channels']");
	
	
	public icCreationPage() throws IOException
	{
		super();
		PageFactory.initElements(driver,this);
	}
	
	public void navigationtoIC()
	{
		Actions ac =new Actions(driver);
  	  ac.clickAndHold(interactIcon).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Use JavaScript to click the element
        js.executeScript("arguments[0].click();", interactiveChannels);
        boolean intellihompage=utility.explicitWaitOfElementpresent(50, driver, interactiveChannelsHomePage);
        Assert.assertTrue(intellihompage, "Landed in IntelliHomePageSuccessfully");
	}
	
	public void navigationtoRTP()
	{
		
		try
		{			
		Actions ac =new Actions(driver);
  	  ac.clickAndHold(interactIcon).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Use JavaScript to click the element
        js.executeScript("arguments[0].click();", icRTPNavigation);
        parentwindow=utility.navigateToNewWindow(driver);
        boolean RTPDashboardnavigation=utility.explicitWaitOfElementpresent(50, driver, RTPDashboardPage);
        Assert.assertTrue(RTPDashboardnavigation, "Naviagated succcesfully to RTP Page from Unica");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
        
	}
	
	public void createIC(String ICName,String ServerGroupName) throws IOException
	{
      try
      {
    	  
          utility.switchFrame(driver, addICPageFrame);
          addInteractiveChannel.click();
          utility.switchFrame(driver, addICPageFrameIC);
          utility.explicitWaitOfElement(40, driver, icName);
          icName.sendKeys(ICName);
          ICSelectPolicy.click();
          icSecurityPolicy.click();
          utility.dropdownSelectionByValue(driver, icRTServerGroup, "newservergrp");
          icSaveandReturn.click();
          utility.switchFrame(driver, addICPageFrame);
          utility.explicitWaitOfElement(40, driver, addInteractiveChannel);
          utility.switchtodefaultframe(driver);

          
          
          
          

    	  
    	
    	  
      }catch(Exception e)
      {
    	  
      }
		
	}
	
	
	

}
