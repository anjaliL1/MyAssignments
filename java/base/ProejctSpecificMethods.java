package base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ProejctSpecificMethods {
	public static ChromeDriver driver;  //to have the same diver value throughout the session and avoid null pointer exception
@BeforeMethod
	public void preCondition()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
