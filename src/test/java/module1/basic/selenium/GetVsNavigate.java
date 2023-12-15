package module1.basic.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetVsNavigate {
	public static void main(String[] args){
		WebDriverManager.edgedriver().setup();
		RemoteWebDriver driver1=new EdgeDriver();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		//using get()
		//driver.get("https://snapdeal.com");
		//navigate.to();
		driver.navigate().to("https://amazon.com");
		driver.navigate().to("https://snapdeal.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();
	}
}
