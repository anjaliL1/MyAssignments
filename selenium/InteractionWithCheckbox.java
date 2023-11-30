package learning.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractionWithCheckbox {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		//max the window
		driver.manage().window().maximize();
		//Add the ImplicityWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Click on the "Basic Checkbox
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
		
		//Click on the "Notification Checkbox.
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		//Verify that the expected message is displayed
		WebElement notiChk = driver.findElement(By.xpath("//span[text()='Checked']"));
		notiChk.click();
		String getText = notiChk.getText();
		if(getText.equalsIgnoreCase("Checked"))
		{
			System.out.println("Expected message is displayed "+getText);
		}
		//Click on your favorite language (assuming it's related to checkboxes).
		driver.findElement(By.xpath("//label[text()='Java']")).click();
			
		//Click on the "Tri-State Checkbox."
		driver.findElement(By.xpath("(//div[contains(@class,'ui-chkbox-box ')])[8]")).click();
		
		//String triAlert = driver.switchTo().alert().getText();
		//System.out.println(triAlert);
		WebElement triPop = driver.findElement(By.xpath("//span[@class='ui-growl-title']"));
		Thread.sleep(1000);
		triPop.click();
		String TriText = triPop.getText();
		System.out.println(TriText);
		

	}

}
