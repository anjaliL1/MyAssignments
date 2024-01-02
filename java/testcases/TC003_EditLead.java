package testcases;

import org.testng.annotations.Test;

import base.ProejctSpecificMethods;
import screen.LoginPage;

public class TC003_EditLead extends ProejctSpecificMethods {
@Test	
	public void runEditLead() throws InterruptedException
	{
		LoginPage obj = new LoginPage();
		obj.enterUname()
		.enterPwd()
		.clickLogin()
		.clickCrmSfa()
		.clickLead()
		.clickFindLead()
		.enterFirstName()
		.clickFindLeads()
		.clickFirstLink()
		.clickEditBtn()
		.changeCname()
		.enterDepartment()
		.clickUpdateBtn()
		.verifyUpdatedDetails();
		
	}

}
