package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchText;
    AddCustomerPage addCustomerPage = new AddCustomerPage();

    public void searchCustomer(String fName, String lName){
        Reporter.log("Searching customer under open account page"+"\n</br>");
        selectByVisibleTextFromDropDown(searchText,fName.trim()+" "+lName.trim());
    }

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyText;


    public void selectCurrency(String currency){
        Reporter.log("Select currency"+"\n</br>");
        selectByVisibleTextFromDropDown(currencyText,currency);
    }

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    public void clickOnProcessButton() {
        clickOnElement(processButton);
    }
    public void verifyAccountCreatedSuccessfullyText(){
        Reporter.log("Clicking on Process button"+"\n</br>");

        String expected = "Account created successfully with account Number :1016";
        String actual = getTextFromAlert();
        Assert.assertEquals(expected.substring(0,20),actual.substring(0,20),"wrong message");
    }


    public void clickOnOkPopUpButton(){

        acceptAlert();
    }
}
