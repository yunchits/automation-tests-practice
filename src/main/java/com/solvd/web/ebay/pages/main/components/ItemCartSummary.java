package com.solvd.web.ebay.pages.main.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemCartSummary extends AbstractUIObject {

    @FindBy(xpath = ".//button[@data-test-id='cart-remove-item']")
    private ExtendedWebElement removeButton;

    public ItemCartSummary(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ItemCartSummary clickRemoveButton() {
        removeButton.click();
        return this;
    }

    public ItemCartSummary isElementPresent(int timeout) {
        removeButton.isElementPresent(timeout);
        return this;
    }
}
