package module1.basic.selenium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownIsShorted {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		//driver.get("https://testautomationpractice.blogspot.com/");
		driver.get("https://www.twoplugs.com/");
		//List<WebElement> element=driver.findElements(By.xpath("//select[@id='country']/option"));
		driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
		Thread.sleep(4000);
		WebElement element=driver.findElement(By.xpath("//select[@name='category_id']"));
		//List<WebElement> element=driver.findElements(By.xpath("(//div[@class='jq-selectbox__dropdown'])[1]/descendant::li"));
		Select sel=new Select(element);
		List<WebElement> elements=sel.getOptions();
		ArrayList original=new ArrayList();
		ArrayList temp=new ArrayList();
		
		for(WebElement ele: elements) {
			//System.out.println(ele.getText());
			original.add(ele.getText());
			temp.add(ele.getText());
		}
		
		System.out.println("Original List is: "+original);
		System.out.println("Temporary List is: "+temp);
		
		Collections.sort(temp);
		System.out.println("Temp List After shorting: "+temp);
		
		if(original.equals(temp)) {
			System.out.println("Dropdown list is in shorted order..");
		}else {
			System.out.println("Dropdown list in not shorted..");
		}
		
		driver.close();
	}

}
