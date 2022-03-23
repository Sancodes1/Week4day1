package Week4day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assigment5AlertsAndFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//setup webdriver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				
		//open url
				driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
				//maximize window
				driver.manage().window().maximize();
				
				driver.switchTo().frame("iframeResult");
				
			  driver.findElement(By.xpath("//button[text()='Try it']")).click();
						
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
				WebElement getTextFun = driver.findElement(By.xpath("//p[@id='demo']"));
				String text = getTextFun.getText();
				System.out.println(text);

				if (text.contains("You pressed OK")) {
					System.out.println("This case is PASSED");

				} else {
					System.out.println("This case is Failed");
				}

			}
				
			     

}
