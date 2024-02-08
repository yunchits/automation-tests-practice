package com.solvd.web.ebay.pages.main.components;

import com.solvd.web.ebay.pages.main.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class SearchLine extends AbstractUIObject {

    @FindBy(xpath = ".//input[@type='text' and @role='combobox']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = ".//input[@id='gh-btn']")
    private ExtendedWebElement searchButton;

    public SearchLine(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public void typeSearchInputValue(String value) {
        searchInput.type(value);
    }
}
