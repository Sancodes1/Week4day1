package Week4day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//setup webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//open url
		driver.get("https://www.irctc.co.in/");
		//maximize window
		driver.manage().window().maximize();
		
		driver.manage() .timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Thread.sleep(4000);
		 driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		 
		 driver.findElement(By.xpath("//a[contains(text(),' FLIGHTS')]")).click();
		 
		 driver.findElement(By.xpath("//a[@href='https://www.air.irctc.co.in']")).click();
		 
		 Set<String> allWindows = driver.getWindowHandles();
		 ArrayList<String> allhandles = new ArrayList<String>(allWindows);
			driver.switchTo().window(allhandles.get(1));

			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='Later']")).click();

			Thread.sleep(6000);

			driver.findElement(By.xpath("(//a[@id='dropdown10'])")).click();

			String text = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).getText();

			System.out.println("customer care email id is : " + text);

		}

	
	    	
	    	
		
	}


