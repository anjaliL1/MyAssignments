package marathon1.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbhiBusTestCase {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com/");;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter Chennai in From Station
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();		
		//Enter Bangalore in To Station
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();		
		//Click on Tomorrow
		driver.findElement(By.xpath("//a[text()='Tomorrow']")).click();		
		//Click on Search
		driver.findElement(By.xpath("//a[text()='Search']")).click();		
		//print the first bus name
		String firstBusName = driver.findElement(By.xpath("(//h5[@class='title'])[1]")).getText();
		System.out.println("Name of first bus is: "+firstBusName);
		//click on sleeper
		driver.findElement(By.xpath("//span[text()='Sleeper']")).click();
		//get the seat available
		String seatAvailable = driver.findElement(By.xpath("(//div[@class='text-grey'])[1]/small")).getText();
		System.out.println(seatAvailable);
		//click on SHow seat
		driver.findElement(By.xpath("(//button[text()='Show Seats'])[1]")).click();
		//choose the seat
		driver.findElement(By.xpath("(//button[@class='seat sleeper'])[1]")).click();
		//select the first boarding point
		driver.findElement(By.xpath("(//div[contains(@class,'container checkbox')])[2]//label")).click();
		//select first drop point
		driver.findElement(By.xpath("(//div[contains(@class,'container checkbox')])[2]//label")).click();
		//get seat num
		String busSeatNo = driver.findElement(By.xpath("//div[@id='seating-selected-seat-details']/span[1]")).getText();
		System.out.println(busSeatNo);
		//get fair details
		String busFair = driver.findElement(By.xpath("//div[@id='seating-selected-seat-details']/span[2]")).getText();
		System.out.println(busFair);
		String title = driver.getTitle();
		System.out.println(title);
		//close the browser
		driver.close();
		

	}

}
