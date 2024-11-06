package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class rerunnerClass {
	
	@CucumberOptions(
	        features = {"@rerun/failed_scenarios.txt"}, 
	        monochrome = true, 
	        plugin = {
	        "pretty", "html:target/cucumber-report/html",
	        "json:target/cucumber-report/json/rerun_cucumber.json"},
	        glue = {"com.stepdef","com.hooks"}
	        )
	 
	public class RerunnerClass extends AbstractTestNGCucumberTests {}

}
