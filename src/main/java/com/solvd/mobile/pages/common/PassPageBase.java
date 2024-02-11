package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PassPageBase extends AbstractPage {

    protected PassPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typePass(String pass);

    public abstract SignedPageBase clickSingIn();

    public abstract boolean isPresent();
}
