package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BankTest extends TestBase {
    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    BankManagerLoginPage bankManagerLoginPage;
    OpenAccountPage openAccountPage;
    AddCustomerPage addCustomerPage;
    AccountPage accountPage;
    CustomerPage customerPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void init() {
        homePage = new HomePage();
        customerLoginPage = new CustomerLoginPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        openAccountPage = new OpenAccountPage();
        addCustomerPage = new AddCustomerPage();
        accountPage = new AccountPage();
        customerPage = new CustomerPage();
    }

    String firstname = "Ron";
    String lastname = "Weasly";
    String postcode = "NW31QE";


    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerTab();
        bankManagerLoginPage.clickOnAddCustomerTab();

        addCustomerPage.enterCustomerDetails(firstname,lastname,postcode);
        addCustomerPage.clickOnAddCustomerBtn();

        addCustomerPage.verifyPopUpMessage();
        addCustomerPage.clickOnPopUpOkButton();

    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldOpenAccountSuccessfully()throws InterruptedException {
        Thread.sleep(1000);
        homePage.clickOnBankManagerTab();
        Thread.sleep(1000);
        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(2000);

        openAccountPage.searchCustomer(firstname, lastname);
        Thread.sleep(2000);
        openAccountPage.selectCurrency("Pound");
        Thread.sleep(2000);
        openAccountPage.clickOnProcessButton();
        Thread.sleep(1000);
        openAccountPage.verifyAccountCreatedSuccessfullyText();
        Thread.sleep(1000);
        openAccountPage.clickOnOkPopUpButton();
        Thread.sleep(1000);

    }

    @Test(groups = {"sanity","regression"})
    public void customerShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchCustomer(firstname, lastname);
        customerLoginPage.clickOnCustomerLoginButton();
        customerPage.verifyLogOutButtonDisplayed();
        customerPage.verifyYourNameTextDisplayed(firstname,lastname);
        customerPage.clickOnLogOutButton();



    }

    @Test (groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnCustomerLoginTab();

        customerLoginPage.searchCustomer(firstname, lastname);
        customerLoginPage.clickOnCustomerLoginButton();

        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositButton();
        accountPage.verifyDepositSuccessFullMessage();

    }

    @Test (groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLoginTab();

        customerLoginPage.searchCustomer(firstname, lastname);
        customerLoginPage.clickOnCustomerLoginButton();

        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositButton();

        Thread.sleep(1000);
        accountPage.clickOnWithdrawlTab();
        Thread.sleep(1000);
        accountPage.enterWithdrawlAmount("25");
        Thread.sleep(1000);
        accountPage.clickOnWithdrawlButton();
        accountPage.verifyTransactionSuccessfulMessage();


    }

}
