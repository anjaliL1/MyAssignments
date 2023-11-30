package learning.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        
        //Select for Source dropdown
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("TestLeaf");
        WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));     
        Select sourcetDrp = new Select(source);
        sourcetDrp.selectByIndex(1);
        
        //Select for MarketCamp dropdown
        WebElement mktC = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
        Select mktCamp = new Select(mktC);
        mktCamp.selectByValue("9002");
        
        //Select for Industry dropdown
        WebElement indus = driver.findElement(By.id("createLeadForm_industryEnumId"));
        Select induDrpDown = new Select(indus);
        induDrpDown.selectByVisibleText("Aerospace");
        driver.findElement(By.name("submitButton")).click();

	}

}
