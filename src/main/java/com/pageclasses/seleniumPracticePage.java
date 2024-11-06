package com.pageclasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;
import com.utility.excelUtility;
import com.utility.utility;

public class seleniumPracticePage extends baseClass {
	
	@FindBy(xpath="//a[text()='Basic Auth']")
	private WebElement basicAuth;
	
	@FindBy(xpath="//*[text()='Broken Images']")
	private WebElement brokenImages;
	
	@FindBy(xpath="//h3[contains(text(),'Broken Images')]/following::Img")
	private List<WebElement> brokenImagesList;
	
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement MockarooSignin;
	
	@FindBy(xpath="//a[text()='Sign up for free.']")
	private WebElement MockarooSignUp;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement MockarooEmail;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement MockarooPassword;
	
	@FindBy(xpath="//input[@name='confirm_password']")
	private WebElement MockarooConfirmPassword;
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement MockarooSubmit;
	
	@FindBy(xpath="Welcome to Mockaroo!")
	private WebElement MackrarooSignupSuccessful;
	
	@FindBy(xpath="(//button[@aria-controls='customized-menu'])[3]")
	private WebElement Mackaroosignupdropdown;
	
	@FindBy(xpath="//*[text()='Sign Out']")
	private WebElement Mackaroosignout;
	

	public seleniumPracticePage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	
	
	public void loginsuccessfulMessage()
	{
		System.out.println("Into Practice Website");
	}
	
	public void basicAuth() throws InterruptedException
	{
		basicAuth.click();
		String usrN="admin";
		String PasN="admin";
		String U="https://"+usrN+":"+PasN+"@the-internet.herokuapp.com";
		driver.get(U);
       //utility.enterWindowCredentials();
		Thread.sleep(1000);
		

	}
	
	public void brokenImagesPath() throws InterruptedException
	{
		try
		{
		brokenImages.click();
		for(WebElement image:brokenImagesList)
		{
			if(image.isDisplayed())
			{
				String broken=image.getAttribute("src");
				boolean value=utility.isImageBroken(broken);
				System.out.println("image is broken"+value);
			}
		}
		driver.navigate().back();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}



	public void completeRegistration(String username, String password) {
		// TODO Auto-generated method stub4
		
		try
		{
			MockarooSignin.click();
			utility.explicitWaitOfElement(20, driver, MockarooSignUp);
			MockarooSignUp.click();
			utility.explicitWaitOfElement(20, driver, MockarooEmail);
			MockarooEmail.sendKeys(username);
			MockarooPassword.sendKeys(password);
			MockarooConfirmPassword.sendKeys(password);
			Actions ac=new Actions(driver);
			ac.moveToElement(MockarooSubmit).doubleClick().build().perform();
			//utility.explicitWaitOfElementVisible(0, driver, MackrarooSignupSuccessful);
			ac.moveToElement(Mackaroosignupdropdown).doubleClick().build().perform();

			utility.explicitWaitOfElement(20, driver, Mackaroosignout);
			Mackaroosignout.click();
			utility.explicitWaitOfElement(20, driver, MockarooSignin);

			
		}catch(Exception e)
		{
			
		}
		
		
	}

}
