package com.solvd.mobile.pages.common;

import com.solvd.mobile.pages.ResultPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends AbstractPage {

    protected SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ResultPage searchByText(String text);

    public abstract HomePageBase clickBack();
}
