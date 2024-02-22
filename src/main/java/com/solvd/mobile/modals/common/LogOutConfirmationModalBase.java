package com.solvd.mobile.modals.common;

import com.solvd.mobile.pages.AuthPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class LogOutConfirmationModalBase extends AbstractPage {

    protected LogOutConfirmationModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    protected LogOutConfirmationModalBase(WebDriver driver) {
        super(driver);
    }

    public abstract AuthPage clickConfirmLogOut();
}