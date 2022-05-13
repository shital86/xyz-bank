package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

    public void clickOnBankManagerTab() {
        clickOnElement(bankManagerLogin);
        Reporter.log("Clicking on bank manager log in tab : " + bankManagerLogin.toString());
    }

    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLoginTab;

    public void clickOnCustomerLoginTab() {
        clickOnElement(customerLoginTab);
        Reporter.log("Clicking on Customer login tab : " + customerLoginTab.toString());

    }
}
