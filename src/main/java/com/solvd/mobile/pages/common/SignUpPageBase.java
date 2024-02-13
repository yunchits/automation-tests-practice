package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignUpPageBase extends AbstractPage {

    protected SignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPresent(int timeout);
}
