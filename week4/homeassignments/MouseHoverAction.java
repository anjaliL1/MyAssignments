package week4.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//get the webelemet
		WebElement menMenu = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		//Mouse Hover Men's Fashion		
		Actions builder = new Actions(driver);
		builder.moveToElement(menMenu).click().perform();
		System.out.println("Men's menu is clicked");
		Thread.sleep(5000);
		//click the shirt label
		WebElement shirt = driver.findElement(By.xpath("(//span[text()='Shirts'])[1]"));
		builder.click(shirt).perform();
		System.out.println("Shirt is clicked");
		//mouse hover the first product
		WebElement firstProduct = driver.findElement(By.xpath("//img[@class='product-image ']"));
		builder.moveToElement(firstProduct).perform();
		//click on quick view of the first product
		WebElement quickView = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		builder.click(quickView).perform();	
		//Thread.sleep(5000);
		driver.close();	
		

	}

}
