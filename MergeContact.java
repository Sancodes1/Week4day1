package Week4day1;

import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//setup webdriver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				
				//open url
				driver.get("http://leaftaps.com/opentaps/control/main");
				//maximize window
				driver.manage().window().maximize();
				
				driver.manage() .timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				//Enter UserName
				WebElement elementUsername = driver.findElement(By.id("username"));
				elementUsername.sendKeys("Demosalesmanager");
				
				//Enter  Password 
				WebElement elementpassword = driver.findElement(By.id("password"));
				elementpassword.sendKeys("crmsfa");
				
				//Click on Login Button
				WebElement elementLoginButton = driver.findElement(By.className("decorativeSubmit"));
				elementLoginButton.click();
				
				//Click on CRM/SFA Link
				WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
				elementCRMSFA.click();
				
				//click on contact
				WebElement elementContact = driver.findElement(By.linkText("Contacts"));
		        elementContact.click();
		        
		        //Click on Merge contacts
		        driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		        
		        driver.findElement(By.xpath("//img[@alt='Lookup'][1]")).click();
		        
		        String windowHandle = driver.getWindowHandle();
		        System.out.println(windowHandle);
		        
		        String currentWindowHandle = driver.getWindowHandle();
		    	System.out.println(currentWindowHandle);
		    	
		    	
		    	//Need to get all window references as a set
		    	Set<String> allWindowHandleSet = driver.getWindowHandles();
		    	
		    	// To get the unique value out of the Set, We are converting Set -> List
		    	ArrayList<String> allWindowHandleList = new ArrayList<String>();
		    	allWindowHandleList.addAll(allWindowHandleSet);
		    	
		    	// Get the unique reference from the list
		    	String newWindow = allWindowHandleList.get(1);
		    	
		    	// Switching to the new window
		    	driver.switchTo().window(newWindow);
		    	System.out.println(driver.getCurrentUrl());
		    	
		    	driver.findElement(By.xpath(" //div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		    	
		    	String newWindow1 = allWindowHandleList.get(0);
		    	driver.switchTo().window(newWindow1);
				  System.out.println(driver.getCurrentUrl());
				  
				  driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
				  
				  Set<String> allWindowset = driver.getWindowHandles();
				  ArrayList<String> allhandles1 = new ArrayList<String>(allWindowset);
					driver.switchTo().window(allhandles1.get(1));
					System.out.println("LookupContacts");
					System.out.println(driver.getCurrentUrl());

					driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
					driver.switchTo().window(allhandles1.get(0));
					driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
					Alert alert = driver.switchTo().alert();
					alert.accept();
					String title = driver.getTitle();
					System.out.println("Title of the screen is " +title);

					if (title.contains("View Contact")) {
						System.out.println("This case is PASSED");

					} else {
						System.out.println("This case is FAILED");
					}
					Thread.sleep(6000);
					driver.close();
				}
				
}				 
				  
				 
	
