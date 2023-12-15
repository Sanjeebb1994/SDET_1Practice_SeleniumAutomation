package module1.basic.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectJQueryDropDown {
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.id("justAnInputBox")).click();
		List<WebElement> multiselection=driver.findElements(By.xpath("(//input[contains(@id,'MultiFilter')])[1]/parent::div/descendant::li/span"));
		jqueryDropDown(multiselection, "choice 1","choice 2 1","choice 2 3","choice 5","choice 6 1","choice 6 2 2","choice 7");
		
		driver.close();
		
	}
	
	public static void jqueryDropDown(List<WebElement> elements, String... value) {
		for(WebElement ele: elements) {
			String text=ele.getText();
			for(String val:value) {
				if(text.equals(val)) {
					ele.click();
					System.out.println(text);
					break;
				}
			}
		}
	}

}
