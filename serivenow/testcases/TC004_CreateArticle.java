package serivenow.testcases;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class TC004_CreateArticle {

	public static void main(String[] args) throws InterruptedException {
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
		action.moveToElement(findElementByXPath).click().sendKeys("Knowledge").perform();

		Thread.sleep(2000);
		WebElement serviceCat = root.findElementByXPath("//mark[text()='Knowledge']");
		Actions action2 = new Actions(driver);
		action2.moveToElement(serviceCat).click().perform();
		
		System.out.println(driver.getTitle());
		//click on article
		WebElement frame = root.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
		
		Thread.sleep(2000);
		//fill in the details
		/*
		 * WebElement frameN = root.findElementByXPath("//iframe[@id='gsft_main']");
		 * driver.switchTo().frame(frameN);
		 */
		driver.findElement(By.id("lookup.kb_knowledge.kb_knowledge_base")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		//click on IT
		driver.findElement(By.xpath("//a[text()='IT']")).click();
		
		//switch back to main window
		driver.switchTo().window(windows.get(0));
		System.out.println(driver.getTitle());
		WebElement frameN = root.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameN);
		//enter short description
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("For Testing purpose");
		//click on submit
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		System.out.println("Article is created successfully");
		//close the browser
		//driver.close();


	}

}
