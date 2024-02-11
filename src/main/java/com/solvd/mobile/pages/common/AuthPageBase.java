package com.solvd.mobile.pages.common;

import com.solvd.mobile.pages.SignInPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AuthPageBase extends AbstractPage {
    protected AuthPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignInPage clickSingInButton();
}
