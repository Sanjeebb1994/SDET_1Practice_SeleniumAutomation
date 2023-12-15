package module3.AdvanceAutomation.TestNG;

import org.testng.annotations.Test;
/**
 * What is TestNG?
 * -->TestNG is a tool which is use for unit Testing.
 * -->It is a next generation testing tool of J-unit
 * -->We can use this tool for various kind of testing like unit Testing, Regression Testing.
 * -->It provides all the features of J-unit along with some advance feature.
 * -->It has auto  mailable report facility.
 * Some Advance features of TestNG tools.
 * --> It provide @Test annotation facility.
 * What is @Test annotation.
 * -->Basically it's a test annotation where we can run our test cases without using main method.
 * -->It is act like a main method but, the thing is method access type should be public and non-static.
 * method has no return type.
 * -->In general we prefer class name as module name and method name always our manual TC name.
 * -->We can create n no.of method by using @Test annotation but, by default it will run in alphabetical order.
 */

public class Test1 {
	
	@Test
	public void createTestNG1() {
		System.out.println("TestNG1 is cresating...");
	}
	
	@Test
	public void updateTestNG1() {
		System.out.println("TestNG1 is updating...");
	}
	
	@Test
	public void deleteTestNG1() {
		System.out.println("TestNG1 is deleting... ");
	}
}
//If we want run in proper order then we have to provide the TC number sequence along with our manual TC.
class CustomerPortal{
	
	@Test
	public void customerPoertal_TC001(){
		System.out.println("Customer portal TC001 is running...");
	}
	
	@Test
	public void customerPortal_TC002() {
		System.out.println("Customer portal TC002 is running...");
	}
	
	@Test
	public void customerPortal_TC003() {
		System.out.println("Customer portal TC003 is running...");
	}
	
}
