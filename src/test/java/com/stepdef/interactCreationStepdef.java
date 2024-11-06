package com.stepdef;

import java.io.IOException;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;

import com.dataInjection.dataInjectionClass;
import com.utility.excelUtility;
import com.utility.utility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class interactCreationStepdef {
	
dataInjectionClass dataInjectionclass;

	
	public interactCreationStepdef(dataInjectionClass dataInjectionclass) throws IOException {
		super();
		this.dataInjectionclass=dataInjectionclass;
		// TODO Auto-generated constructor stub
	}
	
	@Then("I create IC with {string} and {string}")
	public void ReadDataTable(String icname, String runtime,DataTable datatable) throws IOException, InterruptedException {
				
		java.util.List<Map<String, String>> actionData  = datatable.asMaps(String.class, String.class);
		
		
		
		for(Map<String,String>mp:actionData)
		{
			
//		dataInjectionclass.geticCreationPage().createIC();
			String c1=mp.get("column1");
			String c2=mp.get("column2");
			System.out.println(c1);
			System.out.println(c2);
		}
	}
	
		
		@And("I create multiple IC")
		public void multpleIC() throws IOException, InterruptedException {
			
			java.util.List<Map<String, String>> readDataFromExcel= excelUtility.readExcelData();
			
			dataInjectionclass.geticCreationPage().navigationtoIC();
			
			for(Map<String,String>mp1:readDataFromExcel)
			{
				dataInjectionclass.geticCreationPage().createIC(mp1.get("IC Name"),mp1.get("RunTimeServerGroup"));

			}	
			
		}	
		
		@Given("Click on RTP Application from unica")
		public void navigateToRtp() throws IOException, InterruptedException {
			
			dataInjectionclass.getinitilization();  
			dataInjectionclass.geticCreationPage().navigationtoRTP();
			
		}	


}