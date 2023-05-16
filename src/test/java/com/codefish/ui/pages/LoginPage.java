package com.codefish.ui.pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

import java.sql.Driver;
import java.time.Duration;

public class LoginPage {


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement loginButton;
    @FindBy(xpath = "//div[contains(text(),'Authentication failed')]")
    WebElement errorMessage;
    @FindBy(xpath = "//a[.='Logout']")
    WebElement logoutButton;




    public void positiveLogin() {
//        this.username.clear();
//        this.password.clear();
//        this.username.sendKeys(ConfigReader.readProperty("username"));
//        this.password.sendKeys(ConfigReader.readProperty("password"));
        loginButton.click();
    }

    public void loginValidateTitle(String expectedTitle, WebDriver driver) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }

    public void logout() {
        logoutButton.click();
    }


    public void negativeLogin(String username, String password) {
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String loginValidateMessage() {
        return errorMessage.getText();
    }


}
