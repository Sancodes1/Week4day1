package Week4day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerthandle {

	public static void main(String[] args) {
		
		//setup webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//open url
		driver.get("http://www.leafground.com/pages/Alert.html");
		//maximize window
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		String S1 = alert.getText();
		System.out.println(S1);
		alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert alert1 = driver.switchTo().alert();
		String S2 = alert1.getText();
		System.out.println(S2);
		alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert alert2 = driver.switchTo().alert();
		String S3 = alert2.getText();
		alert2.sendKeys("santhosh");
		System.out.println(S3);
		alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Alert alert3 = driver.switchTo().alert();
		String S4 = alert3.getText();
		System.out.println(S4);
		alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	}
	}

