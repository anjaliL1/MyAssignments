package screen;

import org.openqa.selenium.By;

import base.ProejctSpecificMethods;

public class LoginPage extends ProejctSpecificMethods {
	
	public LoginPage enterUname()
	{
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		return this;
	}
	public LoginPage enterPwd()
	{
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}
	public WelcomePage clickLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage();
	}

}
