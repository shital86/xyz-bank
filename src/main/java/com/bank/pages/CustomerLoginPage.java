package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomer;
    @FindBy (xpath = "//button[normalize-space()='Login']")
    WebElement customerLoginButton;

    public void searchCustomer(String fName, String lName) {
        Reporter.log("Searching customer name" + searchCustomer.toString() + "\n</br>");
        selectByVisibleTextFromDropDown(searchCustomer, fName.trim() + " " + lName.trim());
        Reporter.log("Search customer name:" + searchCustomer.toString());
    }

    public void clickOnCustomerLoginButton() {
        Reporter.log("Clicking on log in button"+customerLoginButton.toString()+"\n</br>");
        clickOnElement(customerLoginButton);

    }
}
