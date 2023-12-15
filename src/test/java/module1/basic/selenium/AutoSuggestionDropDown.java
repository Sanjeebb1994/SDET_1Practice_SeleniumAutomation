package module1.basic.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionDropDown {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		List<WebElement> options=driver.findElements(By.xpath("(//div[@role='presentation'])[2]/ul/li"));
		for(WebElement option : options) {
			String value=option.getText();
			//System.out.println(value);
			if(value.equals("selenium download")) {
				System.out.println(value);
				option.click();
				break;
			}
		}
		Thread.sleep(3000L);
		driver.close();
		
	}

}
