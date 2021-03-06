package Week4day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;


public class NumberOfFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = 0;

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		List<WebElement> outerFrame = driver.findElements(By.tagName("iframe"));
		count = count + outerFrame.size();
		System.out.println("Before For Loop" + count);
		for (int i = 0; i < outerFrame.size(); i++) {
			driver.switchTo().frame(i);
			List<WebElement> InnerFrame = driver.findElements(By.tagName("iframe"));
			count = count + InnerFrame.size();
			driver.switchTo().defaultContent();

		}

		System.out.println("Total Number of iframe present in the screen :"  +count);
	}

	}


