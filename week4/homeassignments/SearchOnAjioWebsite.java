package week4.homeassignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchOnAjioWebsite {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//enter bags in search
		driver.findElement(By.name("searchVal")).sendKeys("bags",Keys.ENTER);
		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();
		//click on fashion bags
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		//Get count
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//div[@class='length']/strong")).getText();
		System.out.println(text);
		//get the list of brands
		List<WebElement> brandList = driver.findElements(By.xpath("//div[@class='brand']"));
		List<String> newBrandList = new ArrayList<String>();
		for (int i = 0; i < brandList.size(); i++) {
			String text2 = brandList.get(i).getText();
			newBrandList.add(text2);			
		}
		System.out.println(newBrandList);
		System.out.println(newBrandList.size());
		List<String> newList = new ArrayList<String>();
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='brand']/following-sibling::div[contains(text(),'Bag')]"));
		for (int i = 0; i < findElements.size(); i++) {
			String text2 = findElements.get(i).getText();
			//System.out.println(text2);
			newList.add(text2);
		}
		System.out.println("Name of different bags are: "+newList);
		System.out.println(newList.size());
		driver.close();
		
		
		
		

	}

}
