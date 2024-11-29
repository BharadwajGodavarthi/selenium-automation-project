package com.stepdef;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.dataInjection.dataInjectionClass;
import com.pageclasses.seleniumPracticePage;
import com.utility.excelUtility;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class seleniumPracticeStepdef {
	
	dataInjectionClass datainjectionclass;
	public seleniumPracticeStepdef(dataInjectionClass datainjectionclass)
	{
		this.datainjectionclass=datainjectionclass;
	}
	
	
	@Given("Successfully navigated to selenium practice application")
	public void navigatedToPractice() throws IOException, InterruptedException {
		
		datainjectionclass.getinitilization();
		datainjectionclass.getseleniumPracticePage().loginsuccessfulMessage();
		datainjectionclass.getseleniumPracticePage().basicAuth();
				
	}	
	
	@When("Validated Broken Images on selenium practice application")
	public void validateBrokenImages() throws IOException, InterruptedException {
		
		datainjectionclass.getinitilization();
		datainjectionclass.getseleniumPracticePage().brokenImagesPath();
						
	}	
	
	@Given("Successfully login to application and register users")
	public void ValidateReadingfromExcel() throws IOException, InterruptedException {
		
		datainjectionclass.getinitilization();
		
		List<Map<String,String>> li=excelUtility.readExcelData();
		for(Map<String,String>mp:li)
		{
			datainjectionclass.getseleniumPracticePage().completeRegistration(mp.get("UserName"),mp.get("Password"));

		}
		excelUtility.WriteExcelData("Successfully signedup");	

						
	}	
	

}
