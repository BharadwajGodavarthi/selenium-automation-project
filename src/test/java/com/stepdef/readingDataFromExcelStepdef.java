package com.stepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.collections.Maps;

import com.dataInjection.dataInjectionClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class readingDataFromExcelStepdef {
	
	dataInjectionClass dataInjectionclass;
	
	public readingDataFromExcelStepdef(dataInjectionClass dataInjectionclass){
		
		this.dataInjectionclass=dataInjectionclass;
		
	}
	
    @Given("I create feature file")
    public void iCreateFeatureFile() {
        // Simulate creating a feature file (if needed)
        System.out.println("Feature file created.");
    }

   

    @Then("I perform an action with these values")
    public void iPerformAnAction() {
        // Logic for the action to be performed with the values
        System.out.println("Performed action with provided values.");
    }
    
    
    @When("I use column1 as {string} and column2 as {string}")
    public void iUseColumns(String column1, String column2, DataTable datatable) {
    	
		java.util.List<Map<String, String>> actionData  = datatable.asMaps(String.class, String.class);
		for(Map<String,String>mp:actionData)
		{
System.out.println(mp.get("column1"));	
System.out.println(mp.get("column2"));			

		}
    }

		
	}	




