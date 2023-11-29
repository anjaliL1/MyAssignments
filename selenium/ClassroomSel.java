package learning.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassroomSel {

	public static void main(String[] args) {
		ChromeDriver driver =new ChromeDriver();
        //maximize the browser
        driver.manage().window().maximize();
        //Load the url
        driver.get("http://leaftaps.com/opentaps/control/login");
        //find the element Enter the user name
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        //find the element Enter the password
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        //click login button
        driver.findElement(By.className("decorativeSubmit")).click();
        //click crmsfa
        driver.findElement(By.linkText("CRM/SFA")).click();
        //click Lead
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Create Lead")).click();
        //createLeadForm_companyName
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("TestLeaf");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("TestLeaf");
        driver.findElement(By.name("submitButton")).click();

	}

}
