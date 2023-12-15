package module3.AdvanceAutomation.TestNG;
/**
 * @DataProvider: This annotation provides by TestNG to run the same TC multiple time with different
 * inputs of data.
 * --> In real time we are actually deals with huge set of inputs data.
 * --> Basically DataProvider helps us to perform data driven testing.
 * --> It support two  dimensional object array to store multiple data.
 */

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test5 {
	
	@Test(dataProvider = "dataProvider_TicketBooking")
	public void ticketBooking(String src, String dest) {
		System.out.println("Ticket booked From ==> "+src+" ==> To ==> "+dest);
	}
	
	@DataProvider
	public Object[][] dataProvider_TicketBooking(){
		Object[][] obj=new Object[3][2];
		obj[0][0]="Odisha";
		obj[0][1]="WB";
		
		obj[1][0]="Bangalore";
		obj[1][1]="Mumbai";
		
		obj[2][0]="UP";
		obj[2][1]="Delhi";
		
		return obj;
	}
}

class Students{
	
	@Test(dataProvider = "studentData")
	public void printStudentsData(String name, float hight, char bloodGroup, long rollNum) {
		System.out.println("Student name:: "+name+"\n"+"Hight:: "+hight+"\n"+"BloodGroup:: "+bloodGroup+"\n"+"RollNumber:: "+rollNum+"\n"+"-------------------");
	}
	
	@DataProvider
	public Object[][] studentData(){
		
		Object[][] data=new Object[2][4];
		
		data[0][0]="Sanjeeb";
		data[0][1]=5.11f;
		data[0][2]='B';
		data[0][3]=8658506681L;
		
		data[1][0]="Rajib";
		data[1][1]=4.12f;
		data[1][2]='O';
		data[1][3]=8984263538L;
		
		return data;
	}
}


