package com.CRM_Vtiger.ContactsModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Vtiger_CRM.GenericUtility.BaseClass;

public class CreateOrganizattion extends BaseClass {
	private final WebDriverWait wait = null;
    private final WebDriver driver=null;

    
    private By employeeNameInputLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");
    private By jobTitleDropdownLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div");
    private By locationDropdownLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div");
    private By resetButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]");
    private By searchButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");

    // Use actual element locator for employee list based on your page structure
    // Replace this with your specific locator, not "//*[@id='employee-list']"
    private By employeeListLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div");

    private By employeeNameLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/p[1]"); // Within employee list element

   
    public void clickOnDirectory() {
        By DirectoryLinkLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a");
        WebElement DirectoryLink = wait.until(ExpectedConditions.elementToBeClickable(DirectoryLinkLocator));
        ( DirectoryLink).click();
    }


    public void searchEmployees(String name, String jobTitle, String location) {
        driver.findElement(employeeNameInputLocator).sendKeys(name);
        selectByText(jobTitleDropdownLocator, jobTitle);
        selectByText(locationDropdownLocator, location);
        driver.findElement(searchButtonLocator).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(employeeListLocator));
    }

    public void resetSearch() {
        driver.findElement(resetButtonLocator).click();

        // Add assertions to verify if all input fields and dropdowns are reset to default values. You can use getText() or isDisplayed() methods.
        // Example: assertTrue(driver.findElement(employeeNameInputLocator).getText().isEmpty());
    }

    public List<WebElement> getEmployeeList() {
        return driver.findElements(employeeListLocator);
    }

    public String getEmployeeName(WebElement employeeElement) {
        return employeeElement.findElement(employeeNameLocator).getText();
    }

    private void selectByText(By dropdownLocator, String text) {
        Select dropdown = new Select(driver.findElement(dropdownLocator));
        dropdown.selectByVisibleText(text);
    }

    // Additional methods for searching by other criteria or validating specific details...

}
