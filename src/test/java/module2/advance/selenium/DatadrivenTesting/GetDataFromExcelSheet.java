package module2.advance.selenium.DatadrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDataFromExcelSheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		/*WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");*/
		
		/*FileInputStream fis=new FileInputStream("E:\\V_TigerTestCase\\Organisation.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Testcase");
		Row r=sh.getRow(6);
		Cell c=r.getCell(2);
		String value=c.getStringCellValue();
		System.out.println(value);*/
		//1. Get Data From ExcelSheet.
		FileInputStream fis=new FileInputStream("E:\\Advance Automation\\CRM_Vtiger_TC001.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(1);
		Cell cell=row.getCell(1);
		String empName=cell.getStringCellValue();
		System.out.println("Employee Id is: "+empName);
		/*Cell c=row.getCell(13);
		String empEmail=c.getStringCellValue();
		System.out.println("Employee Name is: "+empEmail);
		Cell c1=row.getCell(15);
		long contactNumber=(long)c1.getNumericCellValue();
		System.out.println("Employee Constact Number is: "+contactNumber);
		
		//1. Using DataFormatter to change any value to String.
		DataFormatter df=new DataFormatter();
		String formatter=df.formatCellValue(c1);
		System.out.println(formatter);
		driver.findElement(By.id("name")).sendKeys(empName);
		driver.findElement(By.id("email")).sendKeys(empEmail);
		WebElement phone=driver.findElement(By.id("phone"));
		phone.sendKeys(String.valueOf(contactNumber));
		phone.clear();
		phone.sendKeys(formatter);
		
		//How to update the Data in excel sheet.
		FileInputStream fis1=new FileInputStream("F:\\API TestCases\\EmployeeData.xlsx");
		Workbook wb1=WorkbookFactory.create(fis1);
		Sheet s1=wb1.getSheet("Sheet1");
		s1.createRow(5).createCell(2).setCellValue("Biswajit Sasmal");
		FileOutputStream fos=new FileOutputStream("F:\\API TestCases\\EmployeeData.xlsx");
		wb1.write(fos);
		String newValue=cell.getStringCellValue();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(newValue);*/
		//fos.flush();
	}

	
}
