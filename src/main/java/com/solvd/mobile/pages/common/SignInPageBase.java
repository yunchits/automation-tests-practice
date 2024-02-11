package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends AbstractPage {
    protected SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPresent();

    public abstract String getCountyText(); // todo

    public abstract void typeEmail(String email);

    public abstract PassPageBase clickContinue();
}
