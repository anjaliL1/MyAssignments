package learning.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegisterationn {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//click on create new button
		driver.findElement(By.linkText("Create new account")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("firstname")).sendKeys("Harry");
		driver.findElement(By.name("lastname")).sendKeys("Pot");
		driver.findElement(By.name("reg_email__")).sendKeys("hary.pot123@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("hary.pot123@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("JaiGurudev@123");
		
		Select dateOf = new Select(driver.findElement(By.name("birthday_day")));
		dateOf.selectByValue("1");
		
		Select dateOfMonth = new Select(driver.findElement(By.name("birthday_month")));
		dateOfMonth.selectByValue("1");
		
		Select dateOfYear = new Select(driver.findElement(By.name("birthday_year")));
		dateOfYear.selectByValue("1974");
		
		driver.findElement(By.xpath("//*[contains(text(),'Male')]")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		//System.out.println("Program ran successfully");	
		driver.close();
		

	}

}
