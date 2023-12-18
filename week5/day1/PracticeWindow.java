package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.*;

public class PracticeWindow {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		/*ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        ChromeDriver driver =new ChromeDriver(opt);*/
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click on 1 click button
		System.out.println("The current window title is: "+driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		//handle the windows
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windlowLst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windlowLst.get(1));
		System.out.println("The opened window title is: "+driver.getTitle());
		driver.close();
		
		//switch back to parent window
		driver.switchTo().window(windlowLst.get(0));
		System.out.println("The current window title is: "+driver.getTitle());
		//step1:Take a snapshot
        File source = driver.getScreenshotAs(OutputType.FILE);
        //Create folder to save the img file
        File desc =new File("./snap/mainPgae.png");
        //Merge source and destination
        FileUtils.copyFile(source, desc);
	
		//click on 2 click button
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		//handle the window
		Set<String> windowHandles2 = driver.getWindowHandles();
		int size = windowHandles2.size();
		System.out.println("Total number of windows opened are:"+size);
		Thread.sleep(2000);
		
		//click the 3 click button
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		System.out.println("Total Num of windows opened are:"+windowHandles3.size());
		List<String> allWIndows = new ArrayList<String>(windowHandles3);
		for (int i = allWIndows.size()-1; i>0 ; --i) {
			String title = driver.switchTo().window(allWIndows.get(i)).getTitle();
			System.out.println(title);
			driver.close();
			
		}
		

	}

}
