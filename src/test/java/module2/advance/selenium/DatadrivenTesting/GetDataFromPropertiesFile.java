package module2.advance.selenium.DatadrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("F:\\API TestCases\\DataStorage.properties");
		
		Properties pobj=new Properties();
		pobj.load(fis);
		
		String browser=pobj.getProperty("Browser");
		String url=pobj.getProperty("URL");
		String username=pobj.getProperty("UserName");
		String password=pobj.getProperty("Password");
	
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		fis.close();
		
		WebDriver driver=null;
	
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\AllWebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver","E:\\AllWebDriver\\EgdeDriver\\msedgedriver.exe");
			driver= new EdgeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\AllWebDriver\\GeckoDriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//Add and modify data;
		pobj.setProperty("Name", "Sanjeeb");
		FileOutputStream fos=new FileOutputStream("F:\\API TestCases\\DataStorage.properties");
		pobj.store(fos, null);
		pobj.replace("Name", "Rajib");
		pobj.store(fos, null);
		fos.close();
		driver.close();
	}
}
