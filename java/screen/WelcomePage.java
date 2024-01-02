package screen;

import org.openqa.selenium.By;

import base.ProejctSpecificMethods;

public class WelcomePage extends ProejctSpecificMethods {
	
	public HomePage clickCrmSfa()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage();
	}

}
