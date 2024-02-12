package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignedPageBase extends AbstractPage {

    protected SignedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPresent(int timeout);

    public abstract HomePageBase clickContinue();
}
