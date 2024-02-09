package com.solvd.web.ebay.pages.base.components;

import com.solvd.web.ebay.pages.main.HomePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Language extends AbstractUIObject {

    @FindBy(xpath = ".//a[@id='gh-eb-Geo-a-default']")
    private ExtendedWebElement languageButton;

    @FindBy(xpath = ".//a[@id='gh-eb-Geo-a-default']//span[@class='gh-eb-Geo-txt']")
    private ExtendedWebElement languageName;

    @FindBy(xpath = ".//a[@id='gh-eb-Geo-a-en']")
    private ExtendedWebElement unselectedLangButton;

    public Language(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getText() {
        return languageName.getText();
    }

    public HomePage setLanguage() {
        languageButton.click();
        unselectedLangButton.click();
        return new HomePage(getDriver());
    }
}
