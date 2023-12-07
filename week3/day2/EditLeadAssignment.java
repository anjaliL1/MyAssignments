package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLeadAssignment {

	public static void main(String[] args) {
		
		String firstName = "Test1";
		
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
		//click on create lead
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		//Enter companyname
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		//enter firstname
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Software Testing");
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("Software Testing");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("abc@gmail.com");
		//select value from dopdown
		WebElement findElement = driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
		Select state = new Select(findElement);
		state.selectByVisibleText("Alaska");
		
		//submit the lead
		driver.findElement(By.name("submitButton")).click();
		
		//click on edit
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		//clear the description
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		//fill the text area
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("Any Text");
		//click on update
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		//gett the title of the resulting page
		String title = driver.getTitle();
		System.out.println("The title of the Resulting page is: "+title);
		//close the browser
		driver.close();
		
		
		
		
		

	}

}
