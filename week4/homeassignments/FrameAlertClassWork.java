package week4.day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAlertClassWork {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//switch to frame
		driver.switchTo().frame(1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//handle alert
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		System.out.println(msg);
		alert.accept();		
		//verification
		String verificationMsg = driver.findElement(By.xpath("//p[contains(text(),'You pressed')]")).getText();
		System.out.println(verificationMsg);
		if(verificationMsg.contains("OK"))
		{
			System.out.println("Alert is accepted");
		}
		else
		{
			System.out.println("Alert is not handled");
		}
		
		driver.close();
		

	}

}
