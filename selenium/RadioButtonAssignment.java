package learning.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonAssignment {

	public static void main(String[] args) throws InterruptedException {
		//Launch the Browser and Load the URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		//Add the ImplicityWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Maximize the browser window.
		driver.manage().window().maximize();
		//Radio selection: Your most favourite browser
		driver.findElement(By.xpath("(//label[text()='Firefox'])[1]")).click();
		//select a radio button and deselect it again and verify if it is unselected
		WebElement bang = driver.findElement(By.xpath("(//span[contains(@class,'radiobutton-icon')])[17]"));
		bang.click();
		Thread.sleep(2000);
		//click the bang again
		bang.click();
		if(bang.isSelected())
		{
			System.out.println("The radio button is selected");
		}
		System.out.println("The radio button is not selected");
		//check if the radio is already selected by default
		WebElement radioSel = driver.findElement(By.xpath("(//label[text()='Safari'])[2]"));
		if(radioSel.isEnabled())
		{
			System.out.println("Radio button is selected by default");
		}
		else{
			System.out.println("Radio button is not selected by default");
		}
		WebElement ageGroup = driver.findElement(By.xpath("(//span[contains(@class,'radiobutton-icon')])[24]"));
		if(ageGroup.isEnabled())
		{
			System.out.println("age already selected");
		}
		else
		{
			System.out.println("age is not already selected");
			ageGroup.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.close();
		
		
	}

}
