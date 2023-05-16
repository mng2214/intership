package com.codefish.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.awt.event.KeyEvent;
import java.util.List;

public class SearchPage {
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "searchfield")
    WebElement searchField;

    @FindBy(xpath = "//div[@class='card-body']//h5")
    List<WebElement> items;

    String itemName ;

    public void searchItemPositiveValidation(String itemName) {
        this.itemName = itemName;
        searchField.sendKeys(itemName, Keys.ENTER);
        for (WebElement item : items) {
            Assert.assertTrue(BrowserUtils.getText(item).contains(itemName));
            break;
        }
    }


}
