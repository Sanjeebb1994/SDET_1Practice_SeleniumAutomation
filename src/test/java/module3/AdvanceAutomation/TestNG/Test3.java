package module3.AdvanceAutomation.TestNG;

import org.testng.annotations.Test;

/*
 * dependsOnMethod is an another parameter comes with @Test annotation parameter, which is use to create 
 * dependable method.
 * --> If we mention dependsOnMethod then it will depends on that particular mentioned method
 * --> If that method got pass then only the next method will rum other it will skip the remaining method.
 */
public class Test3 {
	
	private int[] arr={12,34,21,35,65,32};
	@Test
	public void customerPortal_TC001(){
		System.out.println("Customer portal TC001 is running...");
		System.out.println(arr[2]);
	}
	
	@Test(dependsOnMethods = "customerPortal_TC001")
	public void customerPortal_TC002() {
		System.out.println("Customer portal TC002 is running...");
		System.out.println(arr[3]);
	}
	
	@Test(dependsOnMethods = "customerPortal_TC002")
	public void customerPortal_TC003() {
		System.out.println("Customer portal TC003 is running...");
	}
	
}
//We can use priority and depenedsOnMethod parameter at a time.
class Sample3{
	protected int[] num= {1,2,3,5,4,6};
	
	@Test(priority = 1)
	public void customerPortal_TC001() {
		System.out.println("Customer portal TC001 is Running..");
		System.out.println(num[1]);
	}
	
	@Test(priority = 3,dependsOnMethods = "customerPortal_TC001")
	public void customerPortal_TC002() {
		System.out.println("customer portal TC002 is Running..");
		System.out.println(num[10]);
	}
	
	@Test(priority = 2,dependsOnMethods = "customerPortal_TC002")
	public void customerPortal_TC003() {
		System.out.println("cunstomer portal TC003 is Running..");
	}
}