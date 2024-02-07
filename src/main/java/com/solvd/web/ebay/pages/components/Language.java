package com.solvd.web.ebay.pages.components;

import com.solvd.web.ebay.pages.HomePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class Language extends AbstractUIObject {

    @FindBy(xpath = ".//a[@id='gh-eb-Geo-a-default']")
    private ExtendedWebElement languageButton;

    @FindBy(xpath = ".//span[@class='gh-eb-Geo-txt']")
    private ExtendedWebElement languageName;

    @FindBy(xpath = ".//li[@lang='en-US']//a[@id='gh-eb-Geo-a-en']")
    private ExtendedWebElement englishButton;

    public Language(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage setLanguage() {
        languageButton.click();
        englishButton.click();
        return new HomePage(getDriver());
    }
}
