package week4.day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertInteraction {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://buythevalue.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//switch to frame
		
		//select the first product.
		driver.findElement(By.xpath("//a[contains(text(),'Jobha green apple soap')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]")).click();
		//handle alert
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@data-hover='View Cart']")).click();
		//click on Checkout
		driver.findElement(By.xpath("//input[@id='checkout']")).click();
		//handle alert
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		/*WebElement zipcode = driver.findElement(By.name("wk_zipcode"));//.sendKeys();
		if(zipcode.isDisplayed())
		{
			zipcode.sendKeys("621012");
			driver.findElement(By.xpath("//input[@value='Check']")).click();
			Thread.sleep(5000);
			String text2 = driver.findElement(By.className("wk_availability_msg")).getText();
		    System.out.println(text2);
			
			if(text2.contains("is Available"))
			{
				driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]")).click();
				//handle alert
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//a[text()='View Cart'])[1]")).click();
				//click on Checkout
				driver.findElement(By.xpath("//input[@id='checkout']")).click();
				//handle alert
				Alert alert = driver.switchTo().alert();
				String text = alert.getText();
				System.out.println(text);
				alert.accept();
			}
			else {
				System.out.println("Delivery is not available for the given zipcode, kindly change ");
			}
		}
		else
		{
		
		
		}*/
		driver.close();
		

	}

}
