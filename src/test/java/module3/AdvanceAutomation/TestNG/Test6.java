package module3.AdvanceAutomation.TestNG;
/**
 * --> TestNG provides different kinds of assertion to perform testing in more effective way.
 * --> Those we will see here.
 */

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test6 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite is running...");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite is running...");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class is running...");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class is running...");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method is running...");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method is running...");
	}
	
	@Test(priority = 1, invocationCount = 2)
	public void runningTest1() {
		System.out.println("Test1 is running...");
	}
	
	@Test(priority = 2,dependsOnMethods = "runningTest1", invocationCount = 3)
	public void runningTest2() {
		System.out.println("Test2 is running...");
	}
	
	

}
