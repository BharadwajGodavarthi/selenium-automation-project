package com.dataInjection;

import java.io.IOException;

import com.pageclasses.icCreationPage;
import com.pageclasses.loginPage;
import com.pageclasses.myntraNewValidationPage;
import com.pageclasses.myntraPage;
import com.pageclasses.rtpWebDomainPage;
import com.pageclasses.seleniumPracticePage;

public class dataInjectionClass {

	
	private loginPage loginpageClass;
	private icCreationPage iccreationpageClass;
	public rtpWebDomainPage rtpWebDomainPageClass;
	private seleniumPracticePage seleniumPracticePageClass;
	private myntraPage myntraPageClass;
	private myntraNewValidationPage myntraNewValidationPageClass;

	
	
	
	public loginPage getloginPage()
	{
		return loginpageClass;
	}
	
	public icCreationPage geticCreationPage()
	{
		return iccreationpageClass;
	}
	
	public rtpWebDomainPage getrtpWebDomainPage()
	{
		return rtpWebDomainPageClass;
	}
	
	public seleniumPracticePage getseleniumPracticePage()
	{
		return seleniumPracticePageClass;
	}
	
	public myntraPage getmyntraPage()
	{
		return myntraPageClass;
	}
	
	public myntraNewValidationPage getmyntraNewValidationPage()
	{
		return myntraNewValidationPageClass;
	}
	
	public void getinitilization() throws IOException
	{
		loginpageClass=new loginPage();
		iccreationpageClass=new icCreationPage();
		rtpWebDomainPageClass=new rtpWebDomainPage();
		seleniumPracticePageClass=new seleniumPracticePage();
		myntraPageClass=new myntraPage();
		myntraNewValidationPageClass=new myntraNewValidationPage();
		
	}
	

	
	
}
