package module1.basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Check_VisibleDisplaySelect_Element {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register");
		
		WebElement element=driver.findElement(By.xpath("//input[@id='gender-male']"));
		if(element.isDisplayed()) {
			System.out.println("Male radio button is Displayed");
			if(element.isEnabled()) {
				System.out.println("Male radio button is Enable");
				element.click();
				if(element.isSelected()) {
					System.out.println("Male radio button is selected..");
				}else {
					System.out.println("Male radio button is not selected!!");
				}
			}else {
				System.out.println("Male radio button is not enable!!");
			}
		}else {
			System.out.println("Male radio button is not Display!!!");
		}
		driver.close();
	}
}
