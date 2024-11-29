package com.runner;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class runnerClass {
	private static  String browser;

	@BeforeTest
    @Parameters("browser")
    public static void setBrowser(String browser) {
		
        System.setProperty("browser", browser);
		
		
    }
	
	

	

@CucumberOptions(
		features="src/test/resources/features/Featurefile.feature",
		glue={"com.stepdef","com.hooks"},
	    plugin = {"pretty","rerun:rerun/failed_scenarios.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	    dryRun=false,//Feature file compile and it is true then stepdef class is executed 
	   // tags = "@Single and not @Multiple ",// specific test case @tags name are use here
	    monochrome=true	,    
        tags="@MyntraScenarioShirts"

		)


//implementation of cucumber and testng

public class RunnerClass extends AbstractTestNGCucumberTests {


	
}

}
