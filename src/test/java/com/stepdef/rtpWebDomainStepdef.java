package com.stepdef;

import java.io.IOException;
import java.util.Map;

import com.dataInjection.dataInjectionClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class rtpWebDomainStepdef {

	dataInjectionClass datainjectionclass;
	
	public rtpWebDomainStepdef(dataInjectionClass datainjectionclass)
	{
		this.datainjectionclass=datainjectionclass;
	}
	
	
	
	@Then("Click on webDomaintab in RTP Application")
	public void clickOnRTPApplication() throws IOException, InterruptedException {
		
		datainjectionclass.rtpWebDomainPageClass.webDomainTab();
				
	}
	@And("Create webDomain in RTP Application")
	public void createWebDomainRTP() throws IOException, InterruptedException {
		
		datainjectionclass.rtpWebDomainPageClass.createwebDomainTab();
				
	}
	
	@And("Search and click for webDomain in RTPApplication")
	public void searchWebDomainRTP() throws IOException, InterruptedException {
		
		datainjectionclass.rtpWebDomainPageClass.searchWebDomain();
				
	}
	
	@And("Create webpage on webDomain")
	public void createWebPage() throws IOException, InterruptedException {
		
		datainjectionclass.rtpWebDomainPageClass.createWebPageinWebDomain();
				
	}
	
	@And("Click on webpage in webDomain")
	public void clickOnWebPage() throws IOException, InterruptedException {
		
		datainjectionclass.rtpWebDomainPageClass.clickeWebPageinWebDomain();
				
	}
	
	
}
