package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CustomerPage extends Utility {
    public CustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement logOutButton;
    @FindBy(xpath = "//strong//span[@class='fontBig ng-binding']")
    WebElement nameText;

    public void verifyLogOutButtonDisplayed(){
        Reporter.log("Verifying logout button"+"\n</br>");
        waitUntilVisibilityOfElementLocated(By.xpath("//button[normalize-space()='Logout']"),20);
        boolean actual = logOutButton.isDisplayed();
        Assert.assertFalse(actual);

    }

    public void verifyYourNameTextDisplayed(String fName, String lName){
        //pmWaitUntilVisibilityOfElementLocated((By) nameText,20);
        Reporter.log("Verifying name displayed"+"\n</br>");
        VerifyElement(nameText,fName.trim()+" "+lName.trim(),"wrong name displayed");
    }

    public void clickOnLogOutButton(){
        Reporter.log("Clicking on logout button"+"\n</br>");
        clickOnElement(logOutButton);
    }

}


