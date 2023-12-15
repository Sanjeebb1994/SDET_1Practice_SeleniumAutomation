package com.Vtiger_CRM.Objectrepositary_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="user_name")
	private WebElement userName_EdtElement;
	
	@FindBy(name="user_password")
	private WebElement userPassword_EdtElement;
	
	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath="//input[@id='submitButton']")})
	private WebElement btn_LoginElement;

	public WebElement getUserName() {
		return userName_EdtElement;
	}

	public WebElement getUserPassword() {
		return userPassword_EdtElement;
	}

	public WebElement getBtnLogin() {
		return btn_LoginElement;
	}
	
	/*public void loginApp(String userName,String userPassword) {
		userName_EdtElement.sendKeys(userName);
		userPassword_EdtElement.sendKeys(userPassword);
		btn_LoginElement.click();
	}*/

}
