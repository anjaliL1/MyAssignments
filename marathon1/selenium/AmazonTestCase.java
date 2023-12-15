package marathon1.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTestCase {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//search
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for b");
		driver.findElement(By.xpath("(//span[text()='oys'])[1]")).click();
		//print the total
		String price = driver.findElement(By.xpath("(//div[contains(@class,'a-spacing-small')])[1]")).getText();
		System.out.println(price);
		//select brand
		//Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[text()='Skybags'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("p_89/American Tourister")).click();
		//sort by newest arrival
		driver.findElement(By.xpath("//span[text()='Featured']")).click();
		driver.findElement(By.id("s-result-sort-select_4")).click();
		//get the first bag name
		String bagName = driver.findElement(By.xpath("(//h2[contains(@class,'a-spacing-non')]/a)[1]")).getText();
		System.out.println(bagName);
		//print discounted price of the bag
		String bagPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of the bag is: "+bagPrice);
		//get the title
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		System.out.println("Browser is closed");

	}

}
