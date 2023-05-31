package vTiger;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class vTigerCampaigns 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver =new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("appnavigator")).click();
		Actions a=new Actions(driver);
		WebElement Market = driver.findElement(By.xpath("//span[contains(text(),'MARKETING')]"));
		a.moveToElement(Market).perform();
		WebElement org = driver.findElement(By.xpath("(//span[@class='module-name textOverflowEllipsis'])[1]"));
		a.moveToElement(org).perform();
		org.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("Campaigns_listView_basicAction_LBL_ADD_RECORD")).click();
		Thread.sleep(6000);

		driver.findElement(By.id("Campaigns_editView_fieldName_campaignname")).sendKeys("Get JOB...");
		driver.findElement(By.id("Campaigns_editView_fieldName_targetaudience")).sendKeys("Students & Job Seekers");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);

		driver.findElement(By.id("Campaigns_editView_fieldName_closingdate")).sendKeys("30-06-2023");
		driver.findElement(By.id("Campaigns_editView_fieldName_sponsor")).sendKeys("Qspiders,Deccan");
		Thread.sleep(5000);

		
		driver.findElement(By.id("Campaigns_editView_fieldName_targetsize")).sendKeys("200");
		driver.findElement(By.id("Campaigns_editView_fieldName_budgetcost")).sendKeys("35000");
		driver.findElement(By.id("Campaigns_editView_fieldName_actualcost")).sendKeys("20000");
		driver.findElement(By.id("Campaigns_editView_fieldName_expectedroi")).sendKeys("18");
		driver.findElement(By.id("Campaigns_editView_fieldName_actualroi")).sendKeys("10");
		driver.findElement(By.id("Campaigns_editView_fieldName_description")).sendKeys("Participate in this campaign and Get your Dream Job");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Vtiger/Campaign.png");
		temp.renameTo(dest);
		}
}