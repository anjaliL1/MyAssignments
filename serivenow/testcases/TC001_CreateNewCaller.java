package serivenow.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.sukgu.Shadow;

public class TC001_CreateNewCaller {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disbale-notifications");		
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://dev220999.service-now.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Shadow root = new Shadow(driver);

		//enter username and password and click on submit
		driver.findElement(By.id("user_name")).sendKeys("admin",Keys.TAB);
		driver.findElement(By.id("user_password")).sendKeys("JaiGurudev@1305");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(10000);
		//click on all
		root.findElementByXPath("//div[text()='All']").click();
		Thread.sleep(3000);
		WebElement findElementByXPath = root.findElementByXPath("//label[text()='All filter navigator']");
		Actions action = new Actions(driver);
		action.moveToElement(findElementByXPath).click().sendKeys("Callers").perform();

		Thread.sleep(2000);
		WebElement serviceCat = root.findElementByXPath("//mark[text()='Callers']");
		Actions action2 = new Actions(driver);
		action2.moveToElement(serviceCat).click().perform();

		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		WebElement frameN = root.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameN);		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		System.out.println(driver.getTitle());

		//fill in all the details for creating new caller
		driver.findElement(By.id("sys_user.first_name")).sendKeys("Anju",Keys.TAB);
		driver.findElement(By.id("sys_user.last_name")).sendKeys("Kumari",Keys.TAB);
		driver.findElement(By.id("sys_user.title")).sendKeys("Director",Keys.TAB);
		driver.findElement(By.id("sys_user.email")).sendKeys("ak552@gmail.com",Keys.TAB);
		driver.findElement(By.id("sys_user.phone")).sendKeys("5464474525",Keys.TAB);
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("5987452103",Keys.TAB);
		driver.findElement(By.id("sysverb_insert_bottom")).click();

		//search and verify
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele;
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[1]")));
		//ele.sendKeys("Anjali",Keys.ENTER);
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("Anjali",Keys.ENTER);
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//tr[contains(@id,'row_sys_user')]//td[4]")).getText();
		if(name.contains("Anjali"))
		{
			System.out.println("The name is correctly entered");
		}
		else
		{
			System.out.println("Invalid data");
		}
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/caller.png");
		FileUtils.copyFile(src, dest);
		driver.close();	

	}

}
