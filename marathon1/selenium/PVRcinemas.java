package marathon1.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PVRcinemas {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pvrcinemas.com/");;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//click on Chennai
		driver.findElement(By.xpath("//span[text()='Chennai']")).click();
		Thread.sleep(2000);
		//click on hamburger menu
		driver.findElement(By.xpath("//div[@class='nav-icon']")).click();
		//click on Movie lib
		driver.findElement(By.xpath("//a[text()='Movie Library']")).click();
		Thread.sleep(2000);
		//select the city - use select class
		WebElement cityName = driver.findElement(By.name("city"));
		Select cityDrpDown = new Select(cityName);
		cityDrpDown.selectByVisibleText("Pune");
		//select Genre
		WebElement genreName = driver.findElement(By.name("genre"));
		Select genreDrpDown = new Select(genreName);
		genreDrpDown.selectByVisibleText("ANIMATION");
		//select lang
		WebElement langName = driver.findElement(By.name("lang"));
		Select langDrpDown = new Select(langName);
		langDrpDown.selectByVisibleText("ENGLISH");
		//click on Apply
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(5000);
		//click on first movie
		driver.findElement(By.xpath("//div[@class='movie-list']//img")).click();
		//click on proceed
		driver.findElement(By.xpath("//button[text()='Proceed To Book']")).click();
		//Enter Cinema name
		WebElement cinemaName = driver.findElement(By.id("cinemaName"));
		Select cinemaDrpDown = new Select(cinemaName);
		cinemaDrpDown.selectByVisibleText("PVR Kumar Pacific Pune");
		//select the date
		driver.findElement(By.xpath("//div[@class='datepicker-container datepicker-default']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'22')]")).click();
		//select timings
		WebElement time = driver.findElement(By.name("timings"));
		Select prefferedTime = new Select(time);
		prefferedTime.selectByIndex(0);
		//enter no.of tickets
		driver.findElement(By.name("noOfTickets")).sendKeys("3");
		//enter name
		driver.findElement(By.name("name")).sendKeys("Anjali");
		//enter email
		driver.findElement(By.name("email")).sendKeys("ak40601@gmail.com");
		//Enter phone no
		driver.findElement(By.name("mobile")).sendKeys("8698819987");
		//Select requirement
		WebElement food = driver.findElement(By.name("food"));
		Select confirm = new Select(food);
		confirm.selectByVisibleText("Yes");
		//enter any other details
		driver.findElement(By.name("comment")).sendKeys("Nil");
		//click on checkbox
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Copy To Self']")).click();		
		//click on send request
		driver.findElement(By.xpath("//button[text()='SEND REQUEST']")).click();
		Thread.sleep(2000);
		//click on cacel
		driver.findElement(By.xpath("(//button[text()='CANCEL'])[2]")).click();
		//close the otp screen
		driver.findElement(By.xpath("//button[@class='swal2-close']")).click();
		//verify the title of the page
		String title = driver.getTitle();
		System.out.println("The title of the page is: "+title);
		driver.close();
	}

}
