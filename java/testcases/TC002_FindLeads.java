package testcases;

import org.testng.annotations.Test;

import base.ProejctSpecificMethods;
import screen.LoginPage;

public class TC002_FindLeads extends ProejctSpecificMethods {
@Test	
	public void runFindLeads() throws InterruptedException
	{
		LoginPage lp = new LoginPage();
		lp.enterUname()
		.enterPwd()
		.clickLogin()
		.clickCrmSfa()
		.clickLead()
		.clickFindLead()
		.enterFirstName()
		.clickFindLeads()
		.clickFirstLink()
		.verifyFirstName();
	}

}
