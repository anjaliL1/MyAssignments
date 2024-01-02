package testcases;

import org.testng.annotations.Test;

import base.ProejctSpecificMethods;
import screen.LoginPage;

public class TC004_DeletePage extends ProejctSpecificMethods{
	@Test
	public void runDeleteLead() throws InterruptedException
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
		.clickDelBtn();
	}

}
