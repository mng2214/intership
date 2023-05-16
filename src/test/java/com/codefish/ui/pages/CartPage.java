package com.codefish.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CartPage {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;
    @FindBy(xpath = "//div[@role='alert']")
    WebElement cartEmptyMessage;

    @FindBy(xpath = "//tr[1]//td//button")
    WebElement removeButton;
    @FindBy(xpath = "//a[.='Ecommerce']")
    WebElement eCommerceButton;

//    @FindBy(xpath = "//div[@class='btn-group']//button[@type='button']")
//    List<WebElement> allCategories;
//
//    @FindBy(xpath = "//div[@class='row disp']//img")
//    List<WebElement> categoryImages;

    @FindBy(xpath = "//div[@class='card-body']//button[@type='button']")
    List<WebElement> listProducts;


    public String toCartNavigation() {
        cartButton.click();
        try {
          while (removeButton.isDisplayed()){
              removeButton.click();
              Thread.sleep(250);
            }
        } catch (Exception e) {
        }
        return BrowserUtils.getText(cartEmptyMessage);
    }

    public void addProductsToCart (WebDriver driver){
        eCommerceButton.click();
        Random random = new Random();
        int ranNumber = random.nextInt(listProducts.size());
        int n = ranNumber;
        eCommerceButton.click();
        Actions action = new Actions(driver);
        action.scrollToElement(listProducts.get(n));
        listProducts.get(n).click();



//        for (int i = 1; i < allCategories.size(); i++){
//            allCategories.get(i).click();
//            for (WebElement product : productsToBuy) {
//                BrowserUtils.scrollWithJS(driver,product);
//                product.click();
//            }
//        }
    }


}
