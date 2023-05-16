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
import utils.DriverHelper;

import java.sql.Driver;
import java.time.Duration;

public class LoginPage {
    WebDriver driver = DriverHelper.getDriver();

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement loginButton;

    @FindBy(className = "errorMessage")
    WebElement errorMessage;

    @FindBy(xpath = "//a[.='Logout']")
    WebElement logoutButton;


    public void login(String username, String password) throws InterruptedException {
        this.username.clear();
        this.password.clear();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void loginValidateTitle(String expectedTitle) throws InterruptedException {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
        System.out.println("test");
        }

    public void logout (){
        logoutButton.click();
    }

    public String loginValidateMessage() {
        return errorMessage.getText();
    }


}
