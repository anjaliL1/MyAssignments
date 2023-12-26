package marathon2.advselenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.sukgu.Shadow;

public class OrderingMobile {

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
		action.moveToElement(findElementByXPath).click().sendKeys("Service catalog").perform();
				
		Thread.sleep(2000);
		WebElement serviceCat = root.findElementByXPath("//mark[text()='Service Catalog']");
		Actions action2 = new Actions(driver);
		action2.moveToElement(serviceCat).click().perform();
				
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		WebElement iframe = root.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//a[contains(@id,'item_link')])[2]/h2/strong")).click();
		
		//enter details in opened page
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//label[@class='radio-label'])[1]")).click();
		driver.findElement(By.xpath("(//input[contains(@class,'cat_item_option ')])[4]")).sendKeys("5879648512");
		//choose data allowance
		WebElement dropDwn = driver.findElement(By.xpath("//select[contains(@class,'form-control cat_item_option')]"));
		Select sel = new Select(dropDwn);
		sel.selectByValue("unlimited");
		//choose the color
		driver.findElement(By.xpath("//input[@value='sierra_blue']//following-sibling::label")).click();
		
		//choose the storage
		driver.findElement(By.xpath("//input[@value='512']//following-sibling::label")).click();
		
		//click on Order now
		driver.findElement(By.id("oi_order_now_button")).click();
		
		//Verify order is placed and copy the request number
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		if(text.contains("Thank"))
		{
			System.out.println("The order has been placed");
		}else
		{
			System.out.println("The order has not been placed");
		}
		String requestNo = driver.findElement(By.id("requesturl")).getText();
		System.out.println("The Request Number is: "+requestNo);
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/mobile.png");
		FileUtils.copyFile(src, dest);
		
		System.out.println("You have successfully executed the script! Well Done Anjali!!!!");
		driver.close();
		
	}

}
