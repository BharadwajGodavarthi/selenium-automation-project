package com.stepdef;

import java.util.HashMap;
import java.util.Map;

import com.dataInjection.dataInjectionClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class testingScenarioOutlining {

	dataInjectionClass datainjectionclass;
	public testingScenarioOutlining(dataInjectionClass datainjectionclass)
	{
		
		this.datainjectionclass=datainjectionclass;
	}
	
	
	
    @Given("I create feature filess")
    public void CreateFeatureFiles() {
        // Logic for the action to be performed with the values
        System.out.println("Performed action with provided values.");
    }
    
    @Then("I read column1 as {string} and column2 as {string}")
    public void Readingdummy(String UserName,String Password) {
        
    	String uN=UserName;
    	String Ps=Password;
    	Map<String,String>mp=new HashMap<>();
    	mp.put("Username", uN);
    	mp.put("Password", Ps);
    	System.out.println(mp);

    	
    }
    
    @Then("testing the scenarios")
    public void Readingdummy1() {
        // Logic for the action to be performed with the values
        System.out.println("Performed action with provided values.");
    }
    
    @Then("I read column2 as {string} and column2 as {string}")
    public void Readingdummy2(String UserName,String Password) {
        // Logic for the action to be performed with the values
    	String uN=UserName;
    	String Ps=Password;
    	Map<String,String>mp=new HashMap<>();
    	mp.put("Username", uN);
    	mp.put("Password", Ps);
    	System.out.println(mp);    }
    
    
}
