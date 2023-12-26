package marathon2.advselenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TatacliqTestcase {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.tatacliq.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions action = new Actions(driver);
		WebElement brand = driver.findElement(By.xpath("//div[text()='Brands']"));
		action.moveToElement(brand).perform();
		
		//click on watch & acc
		WebElement watch = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		action.moveToElement(watch).perform();
		
		//click on first item in featured brans
		WebElement firstFtBrand = driver.findElement(By.xpath("//div[text()='Casio']"));
		action.moveToElement(firstFtBrand).click().perform();
		
		//sort from select
		WebElement sortEle = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
		Select option = new Select(sortEle);
		option.selectByValue("isProductNew");
		
		//select the category
		driver.findElement(By.xpath("(//div[@class='FilterDesktop__newFilCheckbox'])[1]")).click();
		Thread.sleep(5000);
		//get the price of all the watches
		List<WebElement> watchPrices = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		List<Integer> price = new ArrayList<Integer>();		
		System.out.println(watchPrices.size());		
		for (int i = 0; i < watchPrices.size(); i++) {
			String text = watchPrices.get(i).getText();
			String replaceAll = text.replaceAll("\\D", "");
			int parseInt = Integer.parseInt(replaceAll);
			price.add(parseInt);
			//System.out.println(price.get(i));
			
			
		}
		
		System.out.println(price.get(0));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele;
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ProductModule__base'])[1]")));
		ele.click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstWindow.get(1));
		
		//get the price
		WebElement priceOfWatch = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3"));
		String text2 = priceOfWatch.getText();
		String replaceAll = text2.replaceAll("\\D", "");
		int priceVal = Integer.parseInt(replaceAll);
		System.out.println(priceVal);
		if(price.get(0)==priceVal)
		{
			System.out.println("The price is same");
		}
		else
		{
			System.out.println("The price is not same");
		}
		
		//click on add to bag
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		
		//get count in bag
		String count = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		System.out.println("No. of items in bag is: " +count);
		
		driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).click();
		
		Thread.sleep(2000);
		//Take the snapshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./output/watch.png");
		FileUtils.copyFile(src, dest);
		System.out.println("The screenshot has been captured");
		
		//close the child window
		System.out.println("The title of new window is: "+driver.getTitle());
		driver.close();
		
		//close the parent window
		driver.switchTo().window(lstWindow.get(0));
		System.out.println("The title of parent window is: "+driver.getTitle());
		driver.close();
				

	}

}
