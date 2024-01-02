package testcases;

import org.testng.annotations.Test;

import base.ProejctSpecificMethods;
import screen.LoginPage;

public class TC001_CreateLead extends ProejctSpecificMethods  {
@Test	
	public void runCrateLead()
	{
		LoginPage lp = new LoginPage();
		lp.enterUname()
		.enterPwd()
		.clickLogin()
		.clickCrmSfa()
		.clickLead()
		.clickCreateLead()
		.enterCname()
		.enterFname()
		.enterLname()
		.clickCreateLeadBtn()
		.verifyFirstName();
	}
	

}
