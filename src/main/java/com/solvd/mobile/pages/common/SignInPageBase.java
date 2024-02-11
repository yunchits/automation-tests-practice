package com.solvd.mobile.pages.common;

import com.solvd.mobile.pages.PassPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends AbstractPage {
    protected SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getCountyText(); // todo

    public abstract void typeEmail(String email);

    public abstract PassPage clickContinue();
}
