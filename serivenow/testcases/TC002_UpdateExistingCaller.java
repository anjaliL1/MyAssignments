package serivenow.testcases;

import java.io.IOException;
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

public class TC002_UpdateExistingCaller {

	public static void main(String[] args) throws InterruptedException {

		String phNo = "9986587420";
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
		ele.sendKeys("Anjali",Keys.ENTER);
		//driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("Anjali",Keys.ENTER);
		Thread.sleep(2000);
		//click on resulted name
		driver.findElement(By.xpath("//tr[contains(@id,'row_sys_user')]//td[3]/a")).click();
		//update the business phno
		driver.findElement(By.id("sys_user.phone")).clear();
		driver.findElement(By.id("sys_user.phone")).sendKeys(phNo,Keys.TAB);
		//click on update
		driver.findElement(By.xpath("//button[text()='Update']")).click();

		//verify the business phno. is updated

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele2;
		ele2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[1]")));
		//ele.sendKeys("Anjali",Keys.ENTER);
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("Anjali",Keys.ENTER);
		String busniessPh = driver.findElement(By.xpath("//tr[contains(@id,'row_sys_user')]//td[5]")).getText();
		System.out.println(busniessPh);
		String replaceAll = busniessPh.replaceAll("\\D", "");
		System.out.println(replaceAll);
		if(replaceAll.contains(phNo))
		{
			System.out.println("The business phone num is updated");
		}
		else
		{
			System.out.println("The business phone num is not updated");
		}

		driver.close();


	}

}
