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

    @When("User logins with correct credentials and login")
    public void userLoginsWithCorrectCredentialsAndLogin() throws InterruptedException {
        loginPage.login(
                ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));
        //loginPage.login("admin","admin");
    }

    @Then("User validates title {string}")
    public void userValidatesTitle(String title) throws InterruptedException {
        loginPage.loginValidateTitle(title);
        loginPage.logout();
    }

    @When("User provides negative {string} and {string} and login")
    public void userProvidesNegativeAndAndLogin(String username, String password) throws InterruptedException {
        loginPage.login(username, password);
    }

    @Then("User validates message {string}")
    public void userValidatesMessage(String message) {
        Assert.assertEquals(message, loginPage.loginValidateMessage());
    }


}
