package com.pageclasses;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;
import com.utility.utility;

public class myntraPage extends baseClass {
	
	
	@FindBy(xpath="//span[text()='Men T-shirts']")
	private WebElement myntraHomePage;
	
	@FindBy(xpath ="//*[@class='slider-rootRail']/div[@role='button' and @id='rootRailThumbLeft']")
	private WebElement myntraPriceSilder;
	
	@FindBy(xpath ="//*[@class='slider-rootRail']/div[@role='button' and @id='rootRailThumbRight']")
	private WebElement myntraPriceSildertoright;
	
	@FindBy(xpath ="//div[@class='slider-dotContainer']")
	private WebElement myntraPriceSliderValues;
	
	
	public myntraPage() throws IOException
	{
		super();
		PageFactory.initElements(driver,this);
	}
	
	public void myntraHomePage()
	{
		utility.explicitWaitOfElementVisible(30, driver, myntraHomePage);
		Assert.assertTrue("We are in Myntra HomePage", myntraHomePage.isDisplayed());
	}
	
	public void myntraPriceNavigator()
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(myntraPriceSilder).clickAndHold(myntraPriceSilder).moveByOffset(10, 0).build().perform();
		ac.moveToElement(myntraPriceSildertoright).clickAndHold(myntraPriceSildertoright).moveByOffset(-10, 0).build().perform();

		
	}
	
	public void myntraPriceexactMover()
	{
        String newValue = "₹100 - ₹1000"; 
        String script = "arguments[0].innerText = '" + newValue + "';";
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(script, myntraPriceSliderValues);


		
	}
	
	
	

}
