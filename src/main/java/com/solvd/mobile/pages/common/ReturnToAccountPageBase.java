package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ReturnToAccountPageBase extends AbstractPage {

    protected ReturnToAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignInPageBase clickRejectButton();

    public abstract HomePageBase clickContinueButton(); //todo

    public abstract String getEmailTitleText();
}
