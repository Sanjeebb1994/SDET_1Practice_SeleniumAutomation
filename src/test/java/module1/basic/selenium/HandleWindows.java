package module1.basic.selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
		
		String ParentID=driver.getWindowHandle();
		System.out.println(ParentID);
		
		driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();
		//1st Approach
		/*Set<String > windowsID=driver.getWindowHandles();
		Iterator<String> id=windowsID.iterator();
		String parentId=id.next();
		String childId=id.next();
		System.out.println("Parent Id is: "+parentId);
		System.out.println("Child Id is: "+childId);
		
		for(String window:windowsID) {
			driver.switchTo().window(window);
			 String title=driver.getTitle();
			 if(title.contentEquals("Your Store")) {
				 System.out.println(title);
				 break;
			 }
		}
		
		driver.findElement(By.xpath("//a[text()='Components']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Components']/parent::li/descendant::li[5]")).click();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//input[@id='male']")).click();
		Thread.sleep(3000);
		driver.close();*/
		//2nd Approach
		Set<String> windowsId=driver.getWindowHandles();
		List<String> windowIdList=new ArrayList(windowsId);
		String ParentId=windowIdList.get(0);
		String ChildId=windowIdList.get(1);
		System.out.println("Parent id is: "+ParentId);
		System.out.println("Child id is "+ChildId);
		for(int i=0;i<windowIdList.size();i++) {
			if(i==1) {
				driver.switchTo().window(windowIdList.get(i));
				System.out.println(driver.getTitle());
				break;
			}
		}
		driver.findElement(By.xpath("//a[text()='Components']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Components']/parent::li/descendant::li[5]")).click();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(ParentId);
		driver.findElement(By.xpath("//input[@id='male']")).click();
		Thread.sleep(3000);
		driver.close();
		//driver.quit();
		
		}
}
