package com.solvd.mobile.pages.common;

import com.solvd.mobile.pages.components.Browse;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPresent(int timeout);

    public abstract void clickAllowNotifications();

    public abstract void closeFeedbackModal();

    public abstract SideMenuPageBase clickOpenSideMenuButton();

    public abstract Browse clickBrowse();
}
