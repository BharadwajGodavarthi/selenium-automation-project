package com.stepdef;

import java.io.IOException;

import com.base.baseClass;
import com.dataInjection.dataInjectionClass;

import io.cucumber.java.en.Given;

public class loginStepdef extends baseClass {
	
	dataInjectionClass dataInjectionclass;

	
	public loginStepdef(dataInjectionClass dataInjectionclass) throws IOException {
		super();
		this.dataInjectionclass=dataInjectionclass;
		// TODO Auto-generated constructor stub
	}


	@Given("^Login to unica Application$")
	public void userLogin() throws IOException, InterruptedException {
		
		System.out.println("Login to the application");
		dataInjectionclass.getinitilization();
		
		dataInjectionclass.getloginPage().logintoIntelliServices();;

		
	
	}

	
	@Given("^Validate the Login Page$")
	public void loginHomePageValidation() throws IOException, InterruptedException {
		
		System.out.println("Verifying whether we are landing on homepage of application");		
		dataInjectionclass.getloginPage().homePageIntelliValidation();
	}

}
