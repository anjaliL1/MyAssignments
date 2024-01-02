package screen;

import org.openqa.selenium.By;

import base.ProejctSpecificMethods;

public class EditLeadPage extends ProejctSpecificMethods {
	
	public EditLeadPage enterDepartment()
	{
		driver.findElement(By.id("updateLeadForm_departmentName")).sendKeys("Testing");
		return this;
	}
	
	public EditLeadPage changeCname()
	{
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Testleaf");
		return this;
	}
	
	public ViewLeadPage clickUpdateBtn()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage();
	}

}
