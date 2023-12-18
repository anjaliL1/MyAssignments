package week5.day1;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class LearnWait {

	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml");
        //find the element
        driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
        System.out.println(driver.getTitle());
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles.size());
        List<String> lstWindow =new ArrayList<String>(windowHandles);
        driver.switchTo().window(lstWindow.get(2));
        System.out.println(driver.getTitle());
	}

}
