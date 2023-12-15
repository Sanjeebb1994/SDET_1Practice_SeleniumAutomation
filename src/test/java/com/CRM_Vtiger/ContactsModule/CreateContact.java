package com.CRM_Vtiger.ContactsModule;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger_CRM.GenericUtility.BaseClass;
import com.Vtiger_CRM.Objectrepositary_POM.ContactPage;

public class CreateContact extends BaseClass{
	
	@Test(groups = {"Smoke"})
	public void createContact_TC001() throws EncryptedDocumentException, IOException {
		System.out.println("CreateContact_TC001 is running...");
		String parentID=driver.getWindowHandle();
		ContactPage contact=new ContactPage(driver);
		String firstName=eLib.getStringDataFromExcel("Sheet1", 1, 1)+jLib.getRandomNumber();
		String organization=eLib.getStringDataFromExcel("Sheet1", 1, 3);
		String title=eLib.getStringDataFromExcel("Sheet1", 1, 5)+jLib.getRandomNumber();
		String department=eLib.getStringDataFromExcel("Sheet1", 1, 6)+jLib.getRandomNumber();
		String email=eLib.getStringDataFromExcel("Sheet1", 1, 7);
		String assistant=eLib.getStringDataFromExcel("Sheet1", 1, 8)+jLib.getRandomNumber();
		long phoneNumber=eLib.getIntDataFromExcel("Sheet1", 1, 9);
		contact.getBtnContact().click();
		WebElement contactPage=contact.getVerifyContactPageElement();
		Assert.assertTrue(contactPage.isDisplayed(), "ContactPage is Open successfully");
		wLib.waitForPageToload(driver);
		contact.getImgCreateNewContactPlusIconElement().click();
		Assert.assertTrue(contact.getVerifyCreateNewContact().isDisplayed(),"Create contact page is open Sucessfully...");
		WebElement firstNameDrpDown=wLib.isVisible(contact.getFirstNameDrpDwn());
		wLib.selectOption(firstNameDrpDown, 1);
		wLib.isVisible(contact.getFirstNameinptBox()).sendKeys(firstName);
		wLib.isVisible(contact.getOrganizationNameImgbtn()).click();
		wLib.switchToWindows(driver, 2);
		wLib.waitForPageToload(driver);
		wLib.takeScreenShot(driver, "OrganizationPage");
		List<WebElement> data=contact.getSelectOrganizationTable();
		wLib.selectElementFromElements(data, organization);
		wLib.switchToParentWindow(driver, parentID);
		WebElement leadDropdown=wLib.isVisible(contact.getLeadSourceDrpDwn());
		wLib.selectOption(leadDropdown, "Employee");
		wLib.isVisible(contact.getTitleInputBox()).sendKeys(title);
		wLib.isVisible(contact.getDepartmentInptBox()).sendKeys(department);
		wLib.isVisible(contact.getEmainInputBox()).sendKeys(email);
		wLib.isVisible(contact.getAssistantInputBox()).sendKeys(assistant);
		wLib.isVisible(contact.getAssistantPhoneInputBox()).sendKeys(String.valueOf(phoneNumber));
		wLib.isVisible(contact.getEmailCheckBox()).click();
		wLib.isVisible(contact.getReferenceCheckBox()).click();
		wLib.isVisible(contact.getNotifyOwnerCheckBox()).click();
		wLib.isVisible(contact.getSaveBtn()).click();
		wLib.acceptAlert(driver);
		System.out.println("CreateContact_TC001 is complete...");
	}
	
	@Test(groups = {"Smoke","Regression"})
	public void createContact_TC002() throws EncryptedDocumentException, IOException {
		String firstName=eLib.getStringDataFromExcel("Sheet1", 1, 1)+jLib.getRandomNumber();
		String lastName=eLib.getStringDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		String organizationName=eLib.getStringDataFromExcel("Sheet1", 1, 3);
		System.out.println("CreateContact_TC002 is Running....");
		String parentId=driver.getWindowHandle();
		ContactPage cp=new ContactPage(driver);
		wLib.isVisible(cp.getBtnContact()).click();
		wLib.waitForPageToload(driver);
		Assert.assertTrue(cp.getVerifyContactPageElement().isDisplayed());
		System.out.println("Contactpage has opened sucessfully...");
		wLib.isVisible(cp.getImgCreateNewContactPlusIconElement()).click();
		wLib.waitForPageToload(driver);
		Assert.assertTrue(cp.getVerifyCreateNewContact().isDisplayed());
		System.out.println("CreateContactPage has opened successFully...");
		wLib.selectOption(cp.getFirstNameDrpDwn(), 1);
		wLib.isVisible(cp.getFirstNameinptBox()).sendKeys(firstName);
		wLib.isVisible(cp.getLastNameInptBox()).sendKeys(lastName);
		wLib.isVisible(cp.getOrganizationNameImgbtn()).click();
		wLib.switchToWindows(driver, 2);
		wLib.waitForPageToload(driver);
		Assert.assertTrue(cp.getVerifyOrganizationPage().isDisplayed());
		System.out.println("OrganizationPage is Open SucessFully...");
		wLib.takeScreenShot(driver, "OrganizationPage");
		wLib.selectElementFromElements(cp.getSelectOrganizationTable(), organizationName);
		wLib.switchToParentWindow(driver, parentId);
		wLib.takeScreenShot(driver, "Contactpage");
		wLib.isVisible(cp.getSaveBtn()).click();
		wLib.waitForPageToload(driver);
		Assert.assertTrue(cp.getSuccesFullyCreateContact().isDisplayed());
		System.out.println("Sucessfully Created contact...");
		System.out.println(cp.getSuccesFullyCreateContact().getText());
		wLib.takeScreenShot(driver, "CreateContact");
		System.out.println("CreateContact_TC002 is completed sucessfully...");
	}
	
	@Test(groups = {"Regression"})
	public void createContact_TC003() throws EncryptedDocumentException, IOException, AWTException, InterruptedException {
		String fName=eLib.getStringDataFromExcel("Sheet1", 1, 1)+jLib.getRandomNumber();
		System.out.println(fName);
		String lName=eLib.getStringDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		System.out.println(lName);
		String orgName=eLib.getStringDataFromExcel("Sheet1", 1, 3);
		System.out.println(orgName);
		String leadSource=eLib.getStringDataFromExcel("Sheet1", 1, 4);
		System.out.println(leadSource);
		String title=eLib.getStringDataFromExcel("Sheet1", 1, 5)+jLib.getRandomNumber();
		System.out.println(title);
		String deptName=eLib.getStringDataFromExcel("Sheet1", 1, 6)+jLib.getRandomNumber();
		System.out.println(deptName);
		String email=eLib.getStringDataFromExcel("Sheet1", 1, 7);
		System.out.println(email);
		String assistant=eLib.getStringDataFromExcel("Sheet1", 1, 8)+jLib.getRandomNumber();
		System.out.println(assistant);
		long phone=eLib.getIntDataFromExcel("Sheet1", 1, 9);
		System.out.println(String.valueOf(phone));
		System.out.println("createContact_TC003 is Running...");
		String pId=driver.getWindowHandle();
		ContactPage cp=new ContactPage(driver);
		wLib.isVisible(cp.getBtnContact()).click();
		wLib.waitForPageToload(driver);
		Assert.assertTrue(cp.getVerifyContactPageElement().isDisplayed());
		System.out.println("Contact List page is visible...");
		wLib.isVisible(cp.getImgCreateNewContactPlusIconElement()).click();
		wLib.waitForPageToload(driver);
		Assert.assertTrue(cp.getVerifyCreateNewContact().isDisplayed());
		System.out.println("Create New Contact is visible...");
		wLib.selectOption(cp.getFirstNameDrpDwn(), 1);
		wLib.isVisible(cp.getFirstNameinptBox()).sendKeys(fName);
		wLib.isVisible(cp.getLastNameInptBox()).sendKeys(lName);
		wLib.isVisible(cp.getOrganizationNameImgbtn()).click();
		wLib.switchToWindows(driver, 2);
		wLib.waitForPageToload(driver);
		Assert.assertTrue(cp.getVerifyOrganizationPage().isDisplayed());
		System.out.println("Organization Page is visible...");
		wLib.takeScreenShot(driver, "OrganizationPage");
		wLib.selectElementFromElements(cp.getSelectOrganizationTable(), orgName);
		wLib.switchToParentWindow(driver, pId);
		wLib.selectOption(cp.getLeadSourceDrpDwn(), leadSource);
		wLib.isVisible(cp.getTitleInputBox()).sendKeys(title);
		wLib.isVisible(cp.getDepartmentInptBox()).sendKeys(deptName);
		wLib.isVisible(cp.getEmainInputBox()).sendKeys(email);
		wLib.isVisible(cp.getAssistantInputBox()).sendKeys(assistant);
		wLib.isVisible(cp.getAssistantPhoneInputBox()).sendKeys(String.valueOf(phone));
		wLib.isVisible(cp.getEmailCheckBox()).click();
		wLib.isVisible(cp.getReferenceCheckBox()).click();
		wLib.isVisible(cp.getNotifyOwnerCheckBox()).click();
		wLib.excecuteJS(driver, "window.scrollBy(0,4000)");
		WebElement filechoose=wLib.isVisible(cp.getFileInputBtn());
		wLib.clickByJS(driver, filechoose);
		//filechoose.sendKeys("C:\\Users\\DELL\\Pictures\\Screenshots\\Tiger.jpg");
		wLib._wait(3000L);
		fLib.uploadFileFromAnyLocation("C:\\Users\\DELL\\Pictures\\Screenshots\\Tiger", ".jpg");
		wLib._wait(3000L);
		wLib.takeScreenShot(driver, "ContactPage");
		wLib.isVisible(cp.getSaveBtn()).click();
		wLib.waitForPageToload(driver);
		Assert.assertTrue(cp.getSuccesFullyCreateContact().isDisplayed());
		System.out.println("Contact created successfully...");
		System.out.println(wLib.isVisible(cp.getSuccesFullyCreateContact()).getText());
		System.out.println("CreateContact_TC003 is completed successfully...");
	}
	
}