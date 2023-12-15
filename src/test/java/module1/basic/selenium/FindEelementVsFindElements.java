package module1.basic.selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindEelementVsFindElements {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register");
		
		//FindElement();
		/*
		WebElement element1=driver.findElement(By.xpath("//input[@id='FirstName']"));
		element1.sendKeys("Sanjeeb");
		
		WebElement element2=driver.findElement(By.xpath("//strong[contains(text(),'Customer service')]/parent::div/following-sibling::ul/child::li/a"));
		String value=element2.getText();
		System.out.println(value);
		
		WebElement element3=driver.findElement(By.xpath("//stong[contains(text(),'Customer service')]/parent::div/following-sibling::ul/child::li/a"));
		String text=element3.getText();
		System.out.println(text);*/
		
		//FindElements();
		List<WebElement> ele1=driver.findElements(By.xpath("//input[@id='FirstName']"));
		System.out.println(ele1.size());
		for(WebElement ele:ele1) {
			ele.sendKeys("Sanjeeb");
		}
		
		List<WebElement> ele2=driver.findElements(By.xpath("//strong[contains(text(),'Customer service')]/parent::div/following-sibling::ul/child::li/a"));
		int size=ele2.size();
		System.out.println(size);
		Iterator<WebElement> it=ele2.iterator();
		for(WebElement ele:ele2) {
			System.out.println(ele.getText());
		}
		//OR
		for(int i=1;i<=size;i++) {
			String text=it.next().getText();
			if(text.equals("News")) {
				System.out.println("Successfully match the element...");
			}
		}
		
		
		driver.close();
	}
}
