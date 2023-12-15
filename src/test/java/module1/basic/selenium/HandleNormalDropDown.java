package module1.basic.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleNormalDropDown {
	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//1. By using select class
		//WebElement element=driver.findElement(By.xpath("//select[@id='country']"));
		//Select sel=new Select(element);
		//Select Method
		//sel.selectByVisibleText("France");
		//sel.selectByValue("uk");
		//sel.selectByIndex(9);
		
		//2. By capturing the element.
		List<WebElement> element=driver.findElements(By.xpath("//select[@id='country']/option"));
		for(WebElement ele : element) {
			String value=ele.getText();
			if(value.equals("Germany")) {
				ele.click();
				break;
			}
		}
		Thread.sleep(3000);
		
		
		driver.close();
	}
}
