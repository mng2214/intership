package com.codefish.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

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


    public void login(String username, String password) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        this.username = wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.clear();
        this.password.clear();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String loginValidateTitle() {
        return driver.getTitle();
    }

    public String loginValidateMessage() {
        return errorMessage.getText();
    }
}
