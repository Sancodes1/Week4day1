package Week4day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//setup webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//open url
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		//maximize window
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
	  driver.findElement(By.xpath("//button[text()='Try it']")).click();
				
		Alert alert = driver.switchTo().alert();
		String S1 = alert.getText();
		alert.sendKeys("santhosh");
		alert.accept();
		
	     driver.switchTo().frame("iframeResult");
		String s2 = driver.findElement(By.xpath("//p[@id='demo']")).getText();

		if (s2.contains("santhosh")) {
			System.out.println("Both the Name matched");
		} else {
			System.out.println("original Name and Duplicate Name did not match");
		}
		
		
	}

}
