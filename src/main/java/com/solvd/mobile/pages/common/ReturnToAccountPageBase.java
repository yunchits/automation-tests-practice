package com.solvd.mobile.pages.common;

import com.solvd.mobile.pages.HomePage;
import com.solvd.mobile.pages.SignInPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ReturnToAccountPageBase extends AbstractPage {

    protected ReturnToAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignInPage clickRejectButton();

    public abstract HomePage clickContinueButton(); //todo

    public abstract String getEmailTitleText();
}
