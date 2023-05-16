package com.codefish.ui.stepdef;

import com.codefish.ui.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class CodeFishLogin {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @When("User logins with positive correct credentials")
    public void userLoginsWithPositiveCorrectCredentials() {
        loginPage.positiveLogin();
    }

    @Then("User validates title {string}")
    public void userValidatesTitle(String title) {
        loginPage.loginValidateTitle(title, driver);
        loginPage.logout();
    }

    @When("User provides negative {string} and {string}")
    public void userProvidesNegativeAnd(String username, String password) {
        loginPage.negativeLogin(username, password);
    }

    @Then("User validates message {string}")
    public void userValidatesMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.loginValidateMessage());
    }

}
