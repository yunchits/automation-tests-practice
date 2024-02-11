package com.solvd.mobile.modals.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FeedbackModalBase extends AbstractPage {

    protected FeedbackModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    protected FeedbackModalBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickRejectButton();
}
