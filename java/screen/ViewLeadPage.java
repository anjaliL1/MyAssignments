package screen;

import org.openqa.selenium.By;

import base.ProejctSpecificMethods;

public class ViewLeadPage extends ProejctSpecificMethods{
	
	public ViewLeadPage verifyFirstName()
	{
		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(text);
		if(text.contains(text))
		{
			System.out.println("The first name is verified");
		}
		else
		{
			System.out.println("The first name is not verified");
		}
		return this;
	}
	
	public EditLeadPage clickEditBtn()
	{
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		return new EditLeadPage();
	}
	
	public void verifyUpdatedDetails()
	{
		System.out.println("Lead is updated with updated details");
	}
	
	public MyLeadPage clickDelBtn()
	{
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		return new MyLeadPage();
	}

}
