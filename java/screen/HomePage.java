package screen;

import org.openqa.selenium.By;

import base.ProejctSpecificMethods;

public class HomePage extends ProejctSpecificMethods {
	
	public MyLeadPage clickLead()
	{
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadPage();
	}

}
