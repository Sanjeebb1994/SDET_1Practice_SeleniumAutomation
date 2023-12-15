package com.Vtiger_CRM.Objectrepositary_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement verifyHomePageElement;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement btn_ContactsElement;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement img_AdministratorElement;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement btn_logoutElement;
	
	@FindBy(xpath="(//table[@cellpadding='0'])[5]/descendant::td")
	private List<WebElement> captureElements;
	
	public WebElement getHomePage() {
		return verifyHomePageElement;
	}
	
	public WebElement getContact() {
		return btn_ContactsElement;
	}
	
	public WebElement getAdminImg() {
		return img_AdministratorElement;
	}

	public WebElement getBtn_logoutElement() {
		return btn_logoutElement;
	}
	
	
	
}
