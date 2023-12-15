package module3.AdvanceAutomation.TestNG;

import org.testng.annotations.Test;
//To make it our own order we have to give a parameter along with @Test annotation called priority.
public class Test2 {
	
	@Test(priority=1)
	public void createTestNG1() {
		System.out.println("TestNG1 is cresating...");
	}
	
	@Test(priority=2)
	public void updateTestNG1() {
		System.out.println("TestNG1 is updating...");
	}
	
	@Test(priority=3)
	public void deleteTestNG1() {
		System.out.println("TestNG1 is deleting... ");
	}
}

class Sample2{
	@Test(priority=3)
	public void createTestNG1() {
		System.out.println("TestNG1 is cresating...");
	}
	
	@Test(priority=2)
	public void updateTestNG1() {
		System.out.println("TestNG1 is updating...");
	}
	
	@Test(priority=1)
	public void deleteTestNG1() {
		System.out.println("TestNG1 is deleting... ");
	}
}