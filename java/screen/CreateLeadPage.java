package screen;

import org.openqa.selenium.By;

import base.ProejctSpecificMethods;

public class CreateLeadPage extends ProejctSpecificMethods {
	
	public CreateLeadPage enterCname()
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");		
		return this;
	}
	public CreateLeadPage enterFname()
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Anjali");
		return this;
	}
	public CreateLeadPage enterLname()
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Tiwari");
		return this;
	}
	public ViewLeadPage clickCreateLeadBtn()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage();
	}
	

}
