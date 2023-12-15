package com.Vtiger_CRM.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class contains all the method related to handle read and write operation with excel sheet.
 * @author Sanjeeb
 */
public class ExcelUtility {
	
	/**
	 * Use to get String cell value from the sheet.
	 * @param sheetName
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getStringDataFromExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("E:\\Advance Automation\\CRM_Vtiger_TC001.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowIndex);
		Cell cell=rw.getCell(columnIndex);
		String value=cell.getStringCellValue();
		return value;
		
	}
	
	/**
	 * Use to get long value from excel sheet.
	 * @param sheetName
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public long getIntDataFromExcel(String sheetName, int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("E:\\Advance Automation\\CRM_Vtiger_TC001.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowIndex);
		Cell cell=rw.getCell(columnIndex);
		long value=(long)cell.getNumericCellValue();
		fis.close();
		return value;
	}
	
	/**
	 * Use to write data into excel sheet.
	 * @param sheetName
	 * @param rowIndex
	 * @param columnIndex
	 * @param setValue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setValueIntoExcel(String sheetName, int rowIndex, int columnIndex, String setValue) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/CRM_Vtiger_TCOO1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).createRow(rowIndex).createCell(columnIndex).setCellValue(setValue);
		FileOutputStream fos=new FileOutputStream("./TestData/CRM_Vtiger_TCOO1.xlsx");
		wb.write(fos);
	}
	
	
}
