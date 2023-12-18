package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowIRCTC {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click on flight link
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		//handle windows
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		String title = driver.getTitle();
		System.out.println("Title of the new opened winodw is: "+title);
		driver.switchTo().window(windowList.get(0));
		System.out.println("The title of parent window is:"+driver.getTitle());
		driver.close();
		driver.switchTo().window(windowList.get(1));
		System.out.println(driver.getTitle());
		//step1:Take a snapshot
        File source = driver.getScreenshotAs(OutputType.FILE);
        //Create folder to save the img file
        File desc =new File("./snap/login.png");
        //Merge source and destination
        FileUtils.copyFile(source, desc);
		driver.close();
		
		
	}

}
