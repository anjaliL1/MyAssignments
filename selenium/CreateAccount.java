package learning.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		
		String accName = "AnjaliTest6";
		
		ChromeDriver driver = new ChromeDriver(); //this will open the chrome browser
		driver.get("http://leaftaps.com/opentaps/.");
		driver.manage().window().maximize(); //this will max the window
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys(accName); //description
		//driver.wait(1000);
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		
		Select drpDownText1 = new Select(driver.findElement(By.name("industryEnumId")));	//syntax to work with drop-down
		drpDownText1.selectByVisibleText("Computer Software");
		
		Select drpDownText2 = new Select(driver.findElement(By.name("ownershipEnumId")));	//creating another object to dealing with new dropdown
		drpDownText2.selectByVisibleText("S-Corporation");
		
		Select drpDownText3 = new Select(driver.findElement(By.id("dataSourceId")));	//creating another object to dealing with new dropdown
		drpDownText3.selectByValue("LEAD_EMPLOYEE");
		
		//marketingCampaignId
		Select mktCamId = new Select(driver.findElement(By.id("marketingCampaignId")));
		mktCamId.selectByIndex(5);
		
		//generalStateProvinceGeoId
		Select stPrvId = new Select(driver.findElement(By.id("generalStateProvinceGeoId")));
		stPrvId.selectByValue("TX");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.findElement(By.className("smallSubmit")).click();
		/*String accNam = driver.findElement(By.className("tabletext")).getText();	
		System.out.println(accNam);
		if(accNam.contains(accName))
		{
			System.out.println("The Account name is displayed correctly");
			
		}*/
		System.out.println("code ran successfully");
		driver.close();
				

	}

}
