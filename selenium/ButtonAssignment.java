package learning.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonAssignment {

	public static void main(String[] args) {
		//Launch the Browser and Load the URL
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.leafground.com/button.xhtml");
				//max the window
				driver.manage().window().maximize();
				//Add the ImplicityWait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				//Click on the button with the text ‘Click and Confirm title.’
				WebElement title = driver.findElement(By.xpath("//h5[text()='Click and Confirm title.']"));
				String text = title.getText();
				if(text.contains("Confirm title"))
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();					
					String title2 = driver.getTitle();
					//Verify that the title of the page is ‘dashboard.’
					if(title2.equalsIgnoreCase("Dashboard"))
					{
						System.out.println("The title of the page is:"+title2);
					}
										
				}
				//
				driver.findElement(By.xpath("//i[contains(@class,'pi-server')]")).click();
				driver.findElement(By.xpath("//span[text()='Button']")).click();
				
				//Check if the button with the text ‘Confirm if the button is disabled’ is disabled.
				WebElement butDis = driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']"));
				String text2 = butDis.getText();
				if(text2.contains("Confirm"))
				{
					WebElement btnDisabled = driver.findElement(By.xpath("//span[text()='Disabled']"));
					if(!btnDisabled.isSelected())
					{
						System.out.println("button is disbaled");
					}
				}
				
				//Find and print the position of the button with the text ‘Submit.’
				String text3 = driver.findElement(By.xpath("(//span[text()='Submit'])[1]")).getText();
				if(text3.contains("Submit"))
				{
					Point location = driver.findElement(By.xpath("(//span[text()='Submit'])[1]")).getLocation();
					System.out.println("Location of the button is: "+location);
				}
				
				//Find and print the background color of the button with the text ‘Find the Save button color.’
				String text4 = driver.findElement(By.xpath("//h5[text()='Find the Save button color']")).getText();
				if(text4.contains("Save button "))
				{
					WebElement colrOfButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']"));
					String cssValue = colrOfButton.getCssValue("background");
					System.out.println("backgroundcolor of the button is: "+cssValue);
				}
				
				//Find and print the height and width of the button with the text ‘Find the height and width of this button.’
				String text5 = driver.findElement(By.xpath("//h5[text()='Find the height and width of this button']")).getText();
				if(text5.contains("height and width "))
				{
					WebElement buttonSize = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
					Dimension size = buttonSize.getSize();
					System.out.println("Size of the box is :"+size );
				}
				
				//Close the browser window.
				driver.close();
				

	}

}
