package com.stepdef;

import java.io.IOException;

import com.dataInjection.dataInjectionClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class myntraStepdef {
	
	
dataInjectionClass dataInjectionclass;
	
	public myntraStepdef(dataInjectionClass dataInjectionclass){
		
		this.dataInjectionclass=dataInjectionclass;
		
	}
	
	
	@Given("I navigate to myntra loginpage")
    public void myntraLoginPage() throws IOException {
        // Simulate creating a feature file (if needed)
        System.out.println("Feature file created.");
        dataInjectionclass.getinitilization();
        dataInjectionclass.getmyntraPage().myntraHomePage();
        
        
    }
	
	@When("Select Price in myntra page")
    public void myntraPriceSelection() throws IOException {
        // Simulate creating a feature file (if needed)
        System.out.println("Feature file created.");
        dataInjectionclass.getmyntraPage().myntraPriceNavigator();
        
        
        
    }

	@Then("Select exactPrice in myntra page")
    public void myntraPriceSelectionExact() throws IOException {
        // Simulate creating a feature file (if needed)
        System.out.println("Feature file created.");
        dataInjectionclass.getmyntraPage().myntraPriceexactMover();
        
        
        
    }

}
