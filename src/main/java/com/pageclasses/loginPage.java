package com.pageclasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.baseClass;
import com.utility.utility;

public class loginPage extends baseClass {
	
	@FindBy(xpath="//input[contains(@id,'username')]")
	private WebElement usernameLogin;
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;
	@FindBy(xpath="//*[text()='Interact']")
	private WebElement interactHomePage;
	
	@FindBy(xpath="//div[@class='popupDragTitleBar']//*[text()='System alerts']")
	private WebElement systemAlert;
	
	@FindBy(xpath="//div[@class='popupDragTitleBar']//*[text()='System alerts']/following::span")
	private WebElement systemAlertDismiss;
	
	private By interactHomePagetest=By.xpath("//*[text()='Interact']");
	
	
	
	public loginPage() throws IOException
	{
		super();
		PageFactory.initElements(driver,this);
	}
	
	public void logintoIntelliServices() throws IOException
	{
		usernameLogin.sendKeys(utility.readProperties("username"));
		loginButton.click();
		utility.implicitWait(40, driver);
		if(systemAlert.isDisplayed())
		{
			systemAlertDismiss.click();
		}
		
	}
	
	public void homePageIntelliValidation() throws IOException
	{
boolean flag= utility.explicitWaitOfElementpresent(40, driver, interactHomePagetest);	
Assert.assertTrue(flag, "Able to land on Intelli HomePage");
utility.implicitWait(40, driver);
	}
	

}
