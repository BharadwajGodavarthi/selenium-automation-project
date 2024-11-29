package com.stepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.dataInjection.dataInjectionClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class myntraNewValidationstepDef {
	
	
	dataInjectionClass dataInjectionclass;
	
	public myntraNewValidationstepDef(dataInjectionClass dataInjectionclass) throws IOException
	{
		this.dataInjectionclass= dataInjectionclass;
        dataInjectionclass.getinitilization();

	}
	
	
	
	@Given("I navigate to myntra loginpage newPage")
    public void myntraLoginPage() throws IOException {
        // Simulate creating a feature file (if needed)
        System.out.println("Feature file created.");
        dataInjectionclass.getmyntraNewValidationPage().testing();
        
        
    }
	
	@When("I set the price range")
	public void myntrapriceRange(DataTable dataTable) throws IOException {
	    List<Map<String, String>> priceRanges = dataTable.asMaps(String.class, String.class);
	    
	    for (Map<String, String> range : priceRanges) {
	        int minPrice = Integer.parseInt(range.get("min").replace("\"", ""));
	        int maxPrice = Integer.parseInt(range.get("max").replace("\"", ""));
	        
	        // Set the price range in your application
	        dataInjectionclass.getmyntraNewValidationPage().setPriceofPage(minPrice, maxPrice);
	        dataInjectionclass.getmyntraNewValidationPage().ValidatePriceofPage(minPrice, maxPrice);
	    }
	}
	
	
	@Then("validate if the image links are broken or not")
	public void myntraBrokenLinks() throws IOException {
		
		dataInjectionclass.getmyntraNewValidationPage().myntraImageBroken();
	    
	    }
	}

	
	