package com.codefish.ui.stepdef;

import com.codefish.ui.pages.CartPage;
import com.codefish.ui.pages.LoginPage;
import com.codefish.ui.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class CodefishCart {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    SearchPage searchPage = new SearchPage(driver);
    CartPage cartPage = new CartPage(driver);

    @And("User navigates to Cart and validates its empty {string}")
    public void userNavigatesToCartAndValidatesItsEmptyCartIsEmpty(String emptyMessage) {
        Assert.assertEquals(emptyMessage, cartPage.toCartNavigation());
    }
    @When("User navigates to search and add one product from each category")
    public void userNavigatesToSearchAndAddOneProductFromEachCategory() {
        cartPage.addProductsToCart(driver);
    }
    @Then("User navigates to Cart and validates added products")
    public void userNavigatesToCartAndValidatesAddedProducts() {

    }



}
