package com.Vtiger_CRM.Objectrepositary_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLastNameInptBox() {
		return lastNameInptBox;
	}

	@FindBy(xpath="//td[@class='moduleName']/child::a")
	private WebElement verifyContactPageElement;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement btnContact;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement imgCreateNewContactPlusIconElement;
	
	@FindBy(xpath="//span[text()='Creating New Contact']")
	private WebElement verifyCreateNewContact;
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement firstNameDrpDwn;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameinptBox;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameInptBox;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement organizationNameImgbtn;
	
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadSourceDrpDwn;
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleInputBox;
	
	@FindBy(xpath="//input[@id='department']")
	private WebElement departmentInptBox;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement emainInputBox;
	
	@FindBy(xpath="//input[@id='assistant']")
	private WebElement assistantInputBox;
	
	@FindBy(xpath="//input[@id='assistantphone']")
	private WebElement assistantPhoneInputBox;
	
	@FindBy(xpath="//input[@name='emailoptout']")
	private WebElement emailCheckBox;
	
	@FindBy(xpath="//input[@name='reference']")
	private WebElement referenceCheckBox;
	
	@FindBy(xpath="//input[@name='notify_owner']")
	private WebElement notifyOwnerCheckBox;
	
	@FindBy(xpath="//div[@id='ListViewContents']/descendant::table[2]/descendant::tr/td/a")
	private List<WebElement> selectOrganizationTable;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement cancelBtn;
	
	@FindBy(xpath="//div[@id='locateMap']/following-sibling::table/descendant::table[9]/descendant::td")
	private WebElement succesFullyCreateContact;
	
	@FindBy(xpath="//td[text()='Organizations']")
	private WebElement verifyOrganizationPage;
	
	@FindBy(xpath="//input[@name='imagename']")
	private WebElement fileInputBtn;
	
	public WebElement getFileInputBtn() {
		return fileInputBtn;
	}

	public WebElement getVerifyOrganizationPage() {
		return verifyOrganizationPage;
	}

	public WebElement getSuccesFullyCreateContact() {
		return succesFullyCreateContact;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public List<WebElement> getSelectOrganizationTable() {
		return selectOrganizationTable;
	}

	public WebElement getVerifyContactPageElement() {
		return verifyContactPageElement;
	}
	
	public WebElement getBtnContact() {
		return btnContact;
	}

	public WebElement getImgCreateNewContactPlusIconElement() {
		return imgCreateNewContactPlusIconElement;
	}

	public WebElement getVerifyCreateNewContact() {
		return verifyCreateNewContact;
	}

	public WebElement getFirstNameDrpDwn() {
		return firstNameDrpDwn;
	}

	public WebElement getFirstNameinptBox() {
		return firstNameinptBox;
	}

	public WebElement getOrganizationNameImgbtn() {
		return organizationNameImgbtn;
	}

	public WebElement getLeadSourceDrpDwn() {
		return leadSourceDrpDwn;
	}

	public WebElement getTitleInputBox() {
		return titleInputBox;
	}

	public WebElement getDepartmentInptBox() {
		return departmentInptBox;
	}

	public WebElement getEmainInputBox() {
		return emainInputBox;
	}

	public WebElement getAssistantInputBox() {
		return assistantInputBox;
	}

	public WebElement getAssistantPhoneInputBox() {
		return assistantPhoneInputBox;
	}

	public WebElement getEmailCheckBox() {
		return emailCheckBox;
	}

	public WebElement getReferenceCheckBox() {
		return referenceCheckBox;
	}

	public WebElement getNotifyOwnerCheckBox() {
		return notifyOwnerCheckBox;
	}
	
	
	
	
}
