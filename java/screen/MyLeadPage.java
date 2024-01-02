package screen;

import org.openqa.selenium.By;

import base.ProejctSpecificMethods;

public class MyLeadPage extends ProejctSpecificMethods {
	
	public CreateLeadPage clickCreateLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage();
	}
	
	public FindLeadPage clickFindLead()
	{
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		return new FindLeadPage();
	}

}
