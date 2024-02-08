package com.solvd.web.ebay.pages.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomeHeader extends AbstractUIObject {

    @FindBy(xpath = ".//ul[@id='gh-eb']")
    private Language languageSetter;

    @FindBy(xpath = ".//*[@id='gh-f']")
    private SearchLine searchLine;

    public HomeHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
