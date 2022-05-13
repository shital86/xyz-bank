package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickAddCustomerBtn;


    public void enterCustomerDetails(String fName, String lName, String pCode) {
        Reporter.log("Entering customer details " + firstName.toString() + " " + lastName.toString() + " " + postCode.toString() + "\n</br>");
        sendTextToElement(firstName, fName);
        sendTextToElement(lastName, lName);
        sendTextToElement(postCode, pCode);
    }

    public void clickOnAddCustomerBtn() {

        clickOnElement(clickAddCustomerBtn);
    }

    public void verifyPopUpMessage() {
        String actual = getTextFromAlert();
        String expected = "Customer added successfully with customer id :6";
        Assert.assertEquals(expected, actual);
        Reporter.log("Verifying customer added successfully message:" + actual);
    }

    public void clickOnPopUpOkButton() {
        Reporter.log("Accepting popup message"+"\n</br>");
        acceptAlert();
    }
}
