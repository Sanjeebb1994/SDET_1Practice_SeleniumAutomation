package module1.basic.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIFrame {
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("windows.scrollTo(0,2000)");
		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//input[@name='RESULT_TextField-0']")).sendKeys("Sanjeeb");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//table[@class='inline_grid choices']/descendant::td[1]/input")).click();
		//driver.switchTo().parentFrame();
	}
}
