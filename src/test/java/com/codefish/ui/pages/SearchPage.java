package com.codefish.ui.pages;

import io.cucumber.java.eo.Se;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.*;

public class SearchPage {
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "searchfield")
    WebElement searchField;

    @FindBy(xpath = "//div[@class='card-body']//h5")
    List<WebElement> items;

    String itemName;

    @FindBy(xpath = "//button[.='Vaccines']")
    WebElement vaccines;
    @FindBy(xpath = "//button[.='Drugs']")
    WebElement drugs;
    @FindBy(xpath = "//button[.='Tools']")
    WebElement tools;
    @FindBy(xpath = "//button[.='Machinery']")
    WebElement machinery;

    @FindBy(xpath = "//div[@class='btn-group']//button[@type='button']")
    List<WebElement> allCategories;
    @FindBy(xpath = "//div[@class='row disp']//img")
    List<WebElement> categoryImages;

//    String vaccinesImg = "https://i.imgur.com/kyk8KtZ.png";
//    String drugsImg = "https://i.imgur.com/ErbeACQ.png";
//    String toolsImg = "https://i.imgur.com/ra3HVae.png";
//    String MachineryImg = "https://i.imgur.com/VMpECDT.png";

    static Set< String> imgUrls = new LinkedHashSet<>();

    public static void linksToList() {
        imgUrls.add( "https://i.imgur.com/kyk8KtZ.png");
        imgUrls.add( "https://i.imgur.com/ErbeACQ.png");
        imgUrls.add( "https://i.imgur.com/ra3HVae.png");
        imgUrls.add( "https://i.imgur.com/VMpECDT.png");
    }


    public void searchItemPositiveValidation(String itemName) {
        this.itemName = itemName;
        searchField.sendKeys(itemName, Keys.ENTER);
        for (WebElement item : items) {
            Assert.assertTrue(BrowserUtils.getText(item).contains(itemName));
            break;
        }
    }

    public void categoryFunctionality() {
        SearchPage.linksToList();
        Set< String> imgUrlsExpected = new LinkedHashSet<>();
        for (int i = 1; i < allCategories.size(); i++) {
            allCategories.get(i).click();
            for (WebElement image : categoryImages) {
                imgUrlsExpected.add(image.getAttribute("src"));
            }
        }
        Assert.assertEquals(imgUrls,imgUrlsExpected);
    }

}
