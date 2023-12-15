package module1.basic.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertPopup {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//1. Handle JS Alert Popup
		/*driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
		Thread.sleep(3000L);
		driver.close();*/
		
		//2. Handle Conform Popup
		/*driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
		Thread.sleep(3000L);
		String text=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
		driver.close();*/
		
		//3. Handle Prompt Popup
		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
		Alert alt=driver.switchTo().alert();
		alt.sendKeys("Sanjeeb");
		String text=alt.getText();
		System.out.println(text);
		//alt.accept();
		alt.dismiss();
		Thread.sleep(3000L);
		String text1=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text1);
		driver.close();
	}

}
