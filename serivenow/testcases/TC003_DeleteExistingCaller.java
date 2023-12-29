package serivenow.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.sukgu.Shadow;

public class TC003_DeleteExistingCaller {

	public static void main(String[] args) throws InterruptedException {
		String name = "Anju";
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

		WebElement frameN = root.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameN);
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele;
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[1]")));
		ele.sendKeys(name,Keys.ENTER);
		//driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("Anjali",Keys.ENTER);
		Thread.sleep(2000);
		//click on resulted name
		driver.findElement(By.xpath("//tr[contains(@id,'row_sys_user')]//td[3]/a")).click();
		
		//delete the caller
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele2;
		ele2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='delete_confirm_form_title']")));
		//confirm delete		
		driver.findElement(By.id("ok_button")).click();
		//verify if delete is working
		Thread.sleep(2000);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele3;
		ele3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[1]")));
		ele3.sendKeys(name,Keys.ENTER);
		//driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("Anjali",Keys.ENTER);
		Thread.sleep(5000);
		String msg = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println(msg);
		if(msg.contains("No"))
		{
			System.out.println("Caller is deleted successfully");
		}
		else
		{
			System.out.println("Caller still exits");
		}
		driver.close();

	}

}
