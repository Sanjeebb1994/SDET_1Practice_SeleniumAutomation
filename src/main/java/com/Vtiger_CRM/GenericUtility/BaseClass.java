package com.Vtiger_CRM.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Vtiger_CRM.Objectrepositary_POM.HomePage;
import com.Vtiger_CRM.Objectrepositary_POM.LoginPage;

public class BaseClass {
	public WebDriver driver;
	
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	
	
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void configBS() {
		System.out.println("=========DB Connection Open=============");
	}
	
	@Parameters("browser")
	@BeforeClass(groups = {"Smoke","Regression"})
	public void configBC() throws IOException {
		System.out.println("==========Launching Browser==============");
		 String browser=fLib.getDataFromPropertiesFile("Browser");
		if(browser.equals("chrome")) {
			System.out.println("Launching:: "+browser);
			System.setProperty("webdriver.chrome.driver", "E:\\AllWebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver();
			wLib.waitForPageToload(driver);
			driver.manage().window().maximize();
		}else if(browser.equals("edge")) {
			System.out.println("Launching:: "+browser);
			System.setProperty("webdriver.edge.driver","E:\\AllWebDriver\\EgdeDriver\\msedgedriver.exe");
			driver=new EdgeDriver();
			wLib.waitForPageToload(driver);
			driver.manage().window().maximize();
		}else {
			System.out.println("Launching:: "+browser);
			System.setProperty("webdriver.gecko.driver", "E:\\AllWebDriver\\GeckoDriver\\geckodriver.exe");
			driver=new FirefoxDriver();
			wLib.waitForPageToload(driver);
			driver.manage().window().maximize();
		}
		
	}
	
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void configBM() throws IOException {
		System.out.println("=============Launchinng URL===============");
		String url=fLib.getDataFromPropertiesFile("URL");
		String userName=fLib.getDataFromPropertiesFile("UserName");
		String password=fLib.getDataFromPropertiesFile("Password");
		System.out.println("URL:: "+url);
		driver.get(url);
		System.out.println("=============Login Application=============");
		LoginPage login=new LoginPage(driver);
		login.getUserName().sendKeys(userName);
		login.getUserPassword().sendKeys(password);
		login.getBtnLogin().click();
		wLib.waitForPageToload(driver);
		HomePage home=new HomePage(driver);
		Assert.assertTrue(home.getHomePage().isDisplayed(), "Home Page Suceessfully Open..");
	}
	
	@AfterMethod(groups = {"Smoke","Regression"})
	public void configAM() {
		HomePage home=new HomePage(driver);
		WebElement image=home.getAdminImg();
		wLib.mouseHoverAction(driver, image);
		home.getBtn_logoutElement().click();
		System.out.println("=============Logout Application===============");
		wLib.waitForPageToload(driver);
	}
	
	@AfterClass(groups = {"Smoke","Regression"})
	public void configAC() {
		driver.quit();
		System.out.println("==============Close Browser=================");
	}
	
	@AfterSuite(groups = {"Smoke","Regression"})
	public void configAS() {
		System.out.println("=================DB Connection Close=================");
	}
	
}
