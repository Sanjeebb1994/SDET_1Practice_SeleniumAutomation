package module1.basic.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSliderBar{
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement increaseRange=driver.findElement(By.xpath("//div[@name='rangeInput']/descendant::span[1]"));
		
		System.out.println("Location of increase Range is:: "+increaseRange.getLocation());//(59, 250)
		System.out.println("Size of increase Range is:: "+increaseRange.getSize());//(21, 21)
		
		Actions act=new Actions(driver);
		act.dragAndDropBy(increaseRange, 100, 0).perform();
		
		System.out.println("Location of increase Range is:: "+increaseRange.getLocation());//(162, 250)
		System.out.println("Size of increase Range is:: "+increaseRange.getSize());//(21, 21)
		
		Thread.sleep(3000);
		WebElement decreaseRange=driver.findElement(By.xpath("//div[@name='rangeInput']/descendant::span[2]"));
		
		System.out.println("Location of decrease Range is:: "+decreaseRange.getLocation());//(526, 250)
		System.out.println("Size of decrease Range is:: "+decreaseRange.getSize());//(21, 21)
		
		act.dragAndDropBy(decreaseRange, -100, 0).perform();
		
		System.out.println("Location of decrease Range is:: "+decreaseRange.getLocation());//(423, 250)
		System.out.println("Size of decrease Range is:: "+decreaseRange.getSize());//(21, 21)
		
		Thread.sleep(3000);
		
		act.dragAndDropBy(increaseRange, -100, 0).perform();
		Thread.sleep(3000);
		act.dragAndDropBy(decreaseRange, 100, 0).perform();
		Thread.sleep(3000);
		driver.close();
	}
}
