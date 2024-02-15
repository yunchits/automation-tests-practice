package com.solvd.web.ebay.pages.main;

import com.solvd.web.ebay.pages.base.BasePage;
import com.solvd.web.ebay.pages.main.components.SearchLine;
import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "gh-f")
    private SearchLine searchLine;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public SearchPage clickSearchButton() {
        searchLine.clickSearchButton();
        return new SearchPage(getDriver());
    }

    public HomePage typeSearchInputValue(String value) {
        searchLine.typeSearchInputValue(value);
        return this;
    }

    public boolean isSearchInputPresent(int timeout) {
        return searchLine.isSearchInputPresent(timeout);
    }

    public boolean isSearchButtonPresent(int timeout) {
        return searchLine.isSearchInputPresent(timeout);
    }
}
