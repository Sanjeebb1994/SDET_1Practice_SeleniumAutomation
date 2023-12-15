package module3.AdvanceAutomation.TestNG;
/**
 * --> Invocation count is use run a particular TC for multiple times.
 */

import org.testng.annotations.Test;

public class Test4 {
	@Test
	public void customerPortal_TC001() {
		System.out.println("Customer portal TC001 is rinning");
	}
	
	@Test(invocationCount = 3)
	public void customerPortal_TC002() {
		System.out.println("Customer portal TC002 is rinning");
	}
	
	@Test(invocationCount = 2)
	public void customerPortal_TC003() {
		System.out.println("Customer portal TC003 is rinning");
	}
}
