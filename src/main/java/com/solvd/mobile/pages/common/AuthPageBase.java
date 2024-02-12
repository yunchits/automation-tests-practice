package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AuthPageBase extends AbstractPage {
    protected AuthPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignInPageBase clickSignInButton();

    public abstract boolean isAuthTitlePresent(int timeout);
}
