package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ReturnToAccountPageBase extends AbstractPage {

    protected ReturnToAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPresent(int timeout);

    public abstract SignInPageBase clickUseAnotherAccount();

    public abstract HomePageBase clickContinue();
}