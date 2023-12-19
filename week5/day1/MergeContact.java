package testcase;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		//merge account
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//click on create account
		driver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		
		//get to contact 
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> toWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(toWindow.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//table[contains(@class,'x-grid3-row-table')])[1]//tr[1]/td[1]/div/a")).click();
		driver.switchTo().window(toWindow.get(0));
		System.out.println(driver.getTitle());
	/*	for (int i = toWindow.size()-1; i >=0 ; i--) {
			if(toWindow.get(i)==toWindow.get(0))
			{
				driver.switchTo().window(toWindow.get(i));
				System.out.println(driver.getTitle());
			}
			else
			{
				Thread.sleep(2000);
				driver.switchTo().window(toWindow.get(i));
				
				WebElement firstTable = driver.findElement(By.xpath("(//table[contains(@class,'x-grid3-row-table')])[1]"));
				List<WebElement> firstRow = firstTable.findElements(By.tagName("tr"));
				driver.findElement(By.xpath("(//table[contains(@class,'x-grid3-row-table')])[1]//tr["+i+"]/td[1]/div/a")).click();				
			}
			
		}*/
		
		//click on from window
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> fromWindow = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(fromWindow.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//table[contains(@class,'x-grid3-row-table')])[2]//tr[1]//td[1]/div/a")).click();
		driver.switchTo().window(fromWindow.get(0));
		System.out.println(driver.getTitle());
		
		//click on merge
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		//handle alert by dismiss
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		//handle alert
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.accept();
		
		//get the title on new page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Boolean until = wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		System.out.println(until);
		System.out.println(driver.getTitle());
		driver.close();
		

	}

}
