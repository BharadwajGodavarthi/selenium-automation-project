package com.pageclasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;
import com.utility.utility;

import junit.framework.Assert;

public class myntraNewValidationPage extends baseClass {
	
	
	@FindBy(xpath="//span[text()='Casual Shirts for Men']")
	private WebElement casualShirtsPage;
	
	@FindBy(xpath="//div[@class='slider-dotContainer']")
	private WebElement priceSlider;
	
	@FindBy(xpath="//span[@class='product-discountedPrice']")
	private List<WebElement> priceList;

	@FindBy(xpath="//*[@id='rootRailThumbLeft']")
	private WebElement priceSilderLeft;
	
	@FindBy(xpath="//*[@id='rootRailThumbRight']")
	private WebElement priceSilderRight;
	
	@FindBy(xpath="//div[@class='product-imageSliderContainer']//img")
	private List<WebElement> myntraImageValidation;
	
	
	public myntraNewValidationPage() throws IOException
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	
	@SuppressWarnings("deprecation")
	public void testing()
	{
		System.out.println("testing Whether navigated to tshirts page or not");
		boolean value=utility.explicitWaitOfElementVisible(10, driver, casualShirtsPage);
		Assert.assertTrue(value);
	}



	public void setPriceofPage(int min,int max) throws IOException {

		
		utility.setPriceRange(min, max, driver, priceSlider);	
		// TODO Auto-generated method stub
		
	}
	
public void myntraImageBroken() throws IOException {
	
	try
	{
		test:
    for(WebElement image:myntraImageValidation)
    {
    	
     if(image.isDisplayed())
     {
    	   String imageBroken= image.getAttribute("src");
    	   boolean value=utility.isImageBroken(imageBroken);
if(value=false)
{
	break test;
}
     }
    	
    }
	
	}catch(Exception e)
	{
		
	}

		
		// TODO Auto-generated method stub
		
	}
	
@SuppressWarnings("deprecation")
public void ValidatePriceofPage(int min,int max) throws IOException {
	boolean flag=true;

	
for(int i=0;i<priceList.size();i++)
{
	String priceofPage=priceList.get(i).getText();
	String[] pricevalue=priceofPage.split("Rs.");
	int price=Integer.valueOf(pricevalue[1].trim());
	
	if(price<min||price>max)
	{
		flag=false;
	}
	
	

}

		System.out.println(flag);
		
	}
	
}
