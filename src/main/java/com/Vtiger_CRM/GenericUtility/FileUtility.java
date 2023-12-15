package com.Vtiger_CRM.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains all the File handle related method
 * @author Sanjeeb
 */
public class FileUtility {
	
	/**
	 * Use to return the value from the properties File.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./CommonData/Vtiger_CRM.properties");
		
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		fis.close(); 
		return value;
	}
	
	public void uploadFileFromAnyLocation(String filePath, String fileExtentionType) throws AWTException {
		Robot r=new Robot();
		r.delay(3000);
		
		//Put path file to file in a clipboard
		StringSelection ss=new StringSelection(filePath+fileExtentionType);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//CTRL+V
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.delay(3000);
		//ENTER
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
