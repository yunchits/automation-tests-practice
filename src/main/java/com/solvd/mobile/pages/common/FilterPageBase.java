package com.solvd.mobile.pages.common;

import com.solvd.mobile.models.Filters;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.helper.IExtendedWebElementHelper;
import org.openqa.selenium.WebDriver;

public abstract class FilterPageBase extends AbstractPage implements IExtendedWebElementHelper {

    protected FilterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract FilterPageBase selectFilter(Filters filter);

    public abstract ResultPageBase clickDone();
}
