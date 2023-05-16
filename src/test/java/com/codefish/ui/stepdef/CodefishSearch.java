package com.codefish.ui.stepdef;

import com.codefish.ui.pages.LoginPage;
import com.codefish.ui.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class CodefishSearch {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    SearchPage searchPage = new SearchPage(driver);


    @When("User login on the website")
    public void userLoginOnTheWebsite() {
        loginPage.positiveLogin();
    }

    @Then("User search for item by {string} from catalog and validates it")
    public void userSearchForItemByFromCatalogAndValidatesIt(String itemName) {
        searchPage.searchItemPositiveValidation(itemName);
    }


    @Then("User switch search by category and validates items belongs to current category")
    public void userSwitchSearchByCategoryAndValidatesItemsBelongsToCurrentCategory() {
        searchPage.categoryFunctionality();
    }
}
