package learning.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/select.xhtml");
		//work with drop donw 1. locate the webelement 2. Instantiate Select Class and 3. Choose value with help of select method
		WebElement autoTools = driver.findElement(By.className("ui-selectonemenu"));
		Select toolDrp = new Select(autoTools);
		toolDrp.selectByIndex(3);
		//toolDrp.selectByVisibleText("Selenium");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//driver.close();
		

	}

}
