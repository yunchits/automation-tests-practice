package com.solvd.web.ebay.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//*[@id='gh-f']")
    private SearchLine searchLine;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
