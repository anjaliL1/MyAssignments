package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeadHomeAssignment {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//click submit
		driver.findElement(By.className("decorativeSubmit")).click(); 
		//click CRMSFA
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		//click on Lead tab
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		//click on Find Lead tab
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		//click on Phone tab
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		//enter phone num
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("45");
		//click on Find Lead button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		//get the lead id
		String text = driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[2]/a")).getText();
		System.out.println(text);
		//click the first resulting lead
		driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[2]/a")).click();
		//delete the lead
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		//click on Find Lead tab
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		//enter the lead
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text);
		//click on Find Lead button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		//getthe text
		String text2 = driver.findElement(By.xpath("//div[contains(text(),'No records ')]")).getText();
		if(text2.equalsIgnoreCase("No records to display"))
		{
			System.out.println("The lead is successfully deleted");
		}
		driver.close();
		
		

	}

}
