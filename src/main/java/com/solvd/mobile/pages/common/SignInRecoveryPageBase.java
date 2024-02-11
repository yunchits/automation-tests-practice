package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInRecoveryPageBase extends AbstractPage {

    protected SignInRecoveryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPresent();

    public abstract HomePageBase clickContinue();

    public abstract SignInPageBase clickUseAnotherAccount();
}
