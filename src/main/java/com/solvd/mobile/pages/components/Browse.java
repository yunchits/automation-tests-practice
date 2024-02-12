package com.solvd.mobile.pages.components;

import com.solvd.mobile.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Browse extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.nike.ntc:id/im_search_workout']")
    private ExtendedWebElement searchInputField;

    public Browse(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchInputPresent(int timeout) {
        return searchInputField.isElementPresent(timeout);
    }

    public SearchPageBase clickSearch() {
        searchInputField.click();
        return initPage(getDriver(), SearchPageBase.class);
    }
}
