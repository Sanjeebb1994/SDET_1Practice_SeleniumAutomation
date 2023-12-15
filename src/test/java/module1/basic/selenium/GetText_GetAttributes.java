package module1.basic.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetText_GetAttributes {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		//getText();
		WebElement element=driver.findElement(By.xpath("//label[contains(text(),'Email')]"));
		String value=element.getText();
		if(value.equals("Email:")) {
			System.out.println("Text value is:: "+value);
		}
		
		//getAttribute();
		element=driver.findElement(By.xpath("//input[@type='password']"));
		String password=element.getAttribute("value");
		System.out.println("Password is: "+password);
		
		driver.close();
	}
}
