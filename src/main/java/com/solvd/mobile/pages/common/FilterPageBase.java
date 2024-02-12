package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FilterPageBase extends AbstractPage {

    protected FilterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract FilterPageBase clickLevelIntermediate();

    public abstract ResultPageBase clickDone();
}
