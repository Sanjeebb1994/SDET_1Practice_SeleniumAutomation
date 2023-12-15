package com.Vtiger_CRM.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.api.model.ErrorDetail;
import com.google.common.io.Files;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

/*********************
 * This class contains WebDriver related methods
 * @author Sanjeeb
 *************************/
public class WebDriverUtility {
	
	/**
	 * Use to wait for page to load id any asynchronous element attached to DOM. 
	 * @param driver
	 */
	public void waitForPageToload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * Use to wait for page to load for asynchronous JS 
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	/**
	 * Use to wait for the element to be clickable in DOM.
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Use to wait for Element To Be clickable with  customize time. 
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	public void waitForElementWithCustomizeTime(WebDriver driver, WebElement element,int pollingTime) throws InterruptedException {
		FluentWait wait =new FluentWait(driver);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
	}
	
	/**
	 * Use to wait for script to be execute for customise time.
	 * @param time
	 * @throws InterruptedException
	 */
	
	public void _wait(long time) throws InterruptedException {
		Thread.sleep(time);
	}
	
	/**
	 * Use to select option from dropDown by using String Value.
	 * @param element
	 * @param value
	 */
	public void selectOption(WebElement element, String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method is use to select option from dropDown by using index value
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * 
	 * @param elements
	 * @param value
	 */
	public void selectOptions(List<WebElement> elements, String... Options) {
		for(WebElement element : elements) {
			String value=element.getText();
			System.out.println(value);
			for(String option: Options) {
				if(value.equals(option)) {
					element.click();
				}
			}
		}
	}
	
	/**
	 * Use to check dropDown options are shorted or not.
	 * @param elements
	 */
	
	public void checkDropDownShorted(List<WebElement> elements) {
		ArrayList<String> original=new ArrayList();
		ArrayList<String> temp=new ArrayList();
		for(WebElement element:elements) {
			original.add(element.getText());
			temp.add(element.getText());
		}
		
		Collections.sort(temp);
		if(original.equals(temp)) {
			System.out.println("Yes ArrayList is shorted..");
			System.out.println(original);
			System.out.println(temp);
		}else {
			System.out.println("No ArrayList is not shorted..");
			System.out.println(original);
			System.out.println(temp);
		}
	}
	
	/**
	 * Use to accept alertPopup.
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}
	
	/**
	 * Use to dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
	}
	
	/**
	 * Use to handle prompt popup
	 * @param driver
	 * @param message
	 */
	public void handlePromtPopup(WebDriver driver, String message) {
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.sendKeys(message);
		alt.accept();
	}
	
	/**
	 * Use to handle Frame
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * Use to switch driver to a particular windows by matching the title.
	 * @param driver
	 * @param expectTitle
	 */
	public void switchToWindows(WebDriver driver, String expectTitle) {
		Set<String> windowsId=driver.getWindowHandles();
		Iterator<String> it=windowsId.iterator();
		while(it.hasNext()) {
			String wId=it.next();
			driver.switchTo().window(wId);
			String actualTitle=driver.getTitle();
			if(actualTitle.contains(expectTitle)) {
				System.out.println("Driver switch to title:: "+actualTitle);
				break;
			}
		}
	}
	
	/**
	 * Use to switch driver to a particular windows by counting the no.of windows.
	 * @param driver
	 * @param num
	 */
	public void switchToWindows(WebDriver driver, int num) {
		Set<String> windowsId=driver.getWindowHandles();
		int length=windowsId.size();
		Iterator<String> it=windowsId.iterator();
		for(int i=1;i<=length;i++) {
			String wId=it.next();
			if(i==num) {
				driver.switchTo().window(wId);
				System.out.println("Driver switch to window Id:: "+wId);
				break;
			}
		}
		
	}
	
	/**
	 * Use to return the driver focus into parent window
	 * @param driver
	 * @param parentId
	 */
	public void switchToParentWindow(WebDriver driver, String parentId ) {
		driver.switchTo().window(parentId);
		System.out.println("Driver switch to Parent Id:: "+parentId);
	}
	
	/**
	 * Use to take screenShot of entire page.
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public void takeScreenShot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShorts/"+screenshotName+getTimeStamp()+".PNG");
		Files.copy(src, dest);
	}
	
	public String getTimeStamp() {
		Date dt=new Date();
		int date=dt.getDate();
		int hr=dt.getHours();
		int min=dt.getMinutes();
		int sec=dt.getSeconds();
		String timeStamp=String.valueOf(date+"_"+hr+"_"+min+"_"+sec);
		return timeStamp;
	}
	/**
	 * Use to take a particular element screenshot.
	 * @param element
	 * @param screenShotName
	 */
	public void takeAParticularElementScreenShot(WebElement element,String screenShotName) {
		File src=element.getScreenshotAs(OutputType.FILE);
		File dest=new File("/.ScreenShorts/"+screenShotName+getTimeStamp()+".PNG");
	}
	
	/**
	 * Use to move mouse to the target Element.
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * Use to Drag and drop the particular element
	 * @param driver
	 * @param sourceElement
	 * @param targetElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		Actions act=new Actions(driver);
		act.dragAndDrop(sourceElement, targetElement).perform();
	}
	
	/**
	 * Use to perform increase the range of a slider Bar.
	 * @param driver
	 * @param element
	 */
	public void performSliderBarAction(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		System.out.println(element.getLocation());
		act.dragAndDropBy(element,100, 0).perform();
		System.out.println(element.getLocation());
	}
	
	/**
	 * Use to perform double click action in a particular element
	 * @param driver
	 * @param element
	 */
	public void performDoubleClickAction(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void performRightClickAction(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		act.contextClick().perform();
	}
	
	/**
	 * Use to perform copy action in a target location.
	 * @param driver
	 * @param element
	 */
	public void performCopyAction(WebDriver driver, WebElement element) {
		Actions act =new Actions(driver);
		act.click(element).perform();
		act.keyUp(Keys.CONTROL);
		act.sendKeys("a"+"c");
		act.keyDown(Keys.CONTROL);
		act.perform();
	}
	
	/**
	 * Use to perform Paste action in a particular element location
	 * @param driver
	 * @param element
	 */
	public void performPasteAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.click(element).perform();
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.perform();
	}
	
	/**
	 * Use to execute java script
	 * @param driver
	 * @param executeScript
	 */
	public void excecuteJS(WebDriver driver, String executeScript) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(executeScript);
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param executeScript
	 */
	public void clickByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Use to check the particular element is visible or not
	 * @param element
	 * @return
	 */
	public WebElement isVisible(WebElement element) {
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(element.isDisplayed(), "Element is not Visible!!!");
		return element;
	}
	
	public WebElement isPresent(WebElement element) {
		Assert.assertTrue(element.isDisplayed(), "Page is not opened!!!");
		return element;
	}
	
	/**
	 * Use to select only one element among all elements.
	 * @param elements
	 * @param expectedValue
	 */
	public void selectElementFromElements(List<WebElement> elements, String expectedValue) {
		for(WebElement element:elements) {
			String value=element.getText();
			if(value.equals(expectedValue)) {
				System.out.println(value);
				element.click();
				break;
			}
		}
	}
	
}
