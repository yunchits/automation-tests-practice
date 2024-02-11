package com.solvd.mobile.pages.common;

import com.solvd.mobile.pages.SettingsPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SideMenuPageBase extends AbstractPage {

    protected SideMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SettingsPageBase clickSettingsButton();
}
