package module1.basic.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMouseHoverAction {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement element=driver.findElement(By.xpath("//button[text()='Copy Text']"));
		//Action class
		Actions act=new Actions(driver);
		//act.doubleClick(element).perform();
		act.moveToElement(element).doubleClick().perform();
		
		//contextClick() --> 
		
		act.moveToElement(element).contextClick().perform();
		Thread.sleep(5000);
		driver.close();
	}
}
