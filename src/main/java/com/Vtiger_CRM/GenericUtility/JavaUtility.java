package com.Vtiger_CRM.GenericUtility;

import java.util.Date;
import java.util.Random;
/**
 *  This class contains Java related methods.
 *  ****************@author Sanjeeb******************
 */

public class JavaUtility {
	
	/**
	 * Use to return random number for up to 1000.
	 * @return randomNumber
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		return ran.nextInt(1000);
	}
	
	/**
	 * Use to return random Number with boundary value.
	 * @param high
	 * @param low
	 * @return
	 */
	public int getRandomNumber(int high, int low) {
		Random rn=new Random();
		int result=rn.nextInt(high-low)+low;
		return result;
	}
	
	/**
	 * Use to return System date and time in IST format.
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date dt=new Date();
		return dt.toString();
	}
	
	/**
	 * Use to return System date with dd/mm/yyyy format.
	 * @return
	 */
	public String getSystemDateWithFormat() {
		Date dt=new Date();
		
		String dateAndTime=dt.toString();
		String yyyy=dateAndTime.split(" ")[5];
		String dd=dateAndTime.split(" ")[2];
		int mm=dt.getMonth()+1;
		String finalFormat=dd+"/"+mm+"/"+yyyy;
		return finalFormat;
	}
	
	/**
	 * Use to return proper date format with user date input
	 * @param date
	 * @return
	 */
	public String getOwnCalanderWithFormat(int date) {
		Date dt=new Date();
		int date1=dt.getDate();
		String dateAndTime=dt.toString();
		String yyyy=dateAndTime.split(" ")[5];
		String dd=dateAndTime.split(" ")[2];
		int mm=dt.getMonth()+1;
		if(date==date1) {
			return dd+"/"+mm+"/"+yyyy;
		}else {
			return date+"/"+mm+"/"+yyyy;
		}
	}
	
	
}
