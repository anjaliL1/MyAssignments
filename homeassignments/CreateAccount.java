package week5.homeassignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String firstName = "Testing5";
		String LastName = "Testing express";
		
		//create account
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//click on create account
		driver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Create Contact')])")).click();
		
		//fields are in table
		WebElement tableAccount = driver.findElement(By.xpath("//div[@class='fieldgroup-body']/table"));
		List<WebElement> rowCount = tableAccount.findElements(By.tagName("tr"));
		System.out.println(rowCount.size());
		driver.findElement(By.id("firstNameField")).sendKeys(firstName);
		driver.findElement(By.id("lastNameField")).sendKeys(LastName);
		driver.findElement(By.name("submitButton")).click();
		
		System.out.println(driver.getTitle());
		driver.close();
		

	}

}
