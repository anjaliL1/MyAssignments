package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnWaitOn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/waits.xhtml");

		//apply explict wait
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		WebElement firstClick1;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		firstClick1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='I am here']")));
		System.out.println(firstClick1.getText());

		//click on second click buton
		driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click();
		WebElement secClick; ////span[text()='I am about to hide']
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		Boolean until = wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='I am about to hide']")));
		System.out.println(until);

		//click on third click
		driver.findElement(By.xpath("//span[text()='Click First Button']")).click();
		WebElement thirdClick;
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement until2 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Click Second']")));
		System.out.println(until2.getText());
		
		//click on 4th click
		driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
		WebElement forthClick = driver.findElement(By.xpath("//span[text()='I am going to change!']"));
		System.out.println(forthClick.getText());
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait4.until(ExpectedConditions.textToBePresentInElement(forthClick, forthClick.getText())); 
		
		driver.close();
		
		
		




	}

}
