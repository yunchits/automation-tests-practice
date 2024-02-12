package com.solvd.mobile.pages.components;

import com.solvd.mobile.pages.ResultPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Browse extends AbstractUIObject {

    @FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.nike.ntc:id/im_search_workout']")
    private ExtendedWebElement searchInputField;

    @FindBy(xpath = "//android.widget.AutoCompleteTextView[@resource-id='com.nike.ntc:id/search_src_text']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.nike.ntc:id/title']")
    private ExtendedWebElement searchButton;

    public Browse(WebDriver driver) {
        super(driver);
    }

    public ResultPage search(String text) {
//        AndroidKey
        searchInputField.click();
        searchInput.type(text);
        searchButton.click();
        return new ResultPage(getDriver());
    }

    public boolean isSearchInputPresent(int timeout) {
        return searchInput.isElementPresent(timeout);
    }
}
