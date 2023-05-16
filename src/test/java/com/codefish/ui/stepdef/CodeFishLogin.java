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

    @When("User logins with correct credentials")
    public void userLoginsWithCorrectCredentials() {
        loginPage.login(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
    }

    @Then("User validates title {string}")
    public void userValidatesTitle(String title) {
        System.out.println(loginPage.loginValidateTitle());
    }


    @When("User provides negative {string} and {string}")
    public void userProvidesNegativeAnd(String username, String password) {

    }
    @Then("User validates message {string}")
    public void userValidatesMessage(String string) {

    }



}
