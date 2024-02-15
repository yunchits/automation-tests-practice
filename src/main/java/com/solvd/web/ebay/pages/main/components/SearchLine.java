package com.solvd.web.ebay.pages.main.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLine extends AbstractUIObject {

    @FindBy(xpath = ".//input[@type='text' and @role='combobox']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = ".//input[@id='gh-btn']")
    private ExtendedWebElement searchButton;

    public SearchLine(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void typeSearchInputValue(String value) {
        searchInput.type(value);
    }

    public boolean isSearchInputPresent(int timeout) {
        return searchInput.isElementPresent(timeout);
    }

    public boolean isSearchButtonPresent(int timeout) {
        return searchButton.isElementPresent(timeout);
    }
}
