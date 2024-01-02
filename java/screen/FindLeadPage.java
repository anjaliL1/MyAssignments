package screen;

import org.openqa.selenium.By;

import base.ProejctSpecificMethods;

public class FindLeadPage extends ProejctSpecificMethods{
	
	public FindLeadPage enterFirstName() {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Anjali");
		return this;
		
	}
	
	public FindLeadPage clickFindLeads() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	
	public ViewLeadPage clickFirstLink() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner')]/a")).click();
		return new ViewLeadPage();
	}

}
