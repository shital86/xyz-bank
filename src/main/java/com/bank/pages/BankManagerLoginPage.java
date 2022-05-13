package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
    public BankManagerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomerTab;

    @FindBy (xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccountTab;



    public void clickOnAddCustomerTab(){
        Reporter.log("Clicking on add customer tab"+addCustomerTab.toString()+"\n</br>");
        clickOnElement(addCustomerTab);
    }

    public void clickOnOpenAccountTab(){
        Reporter.log("Clicking on add customer tab"+openAccountTab.toString()+"\n</br>");
        clickOnElement(openAccountTab);
    }
}
