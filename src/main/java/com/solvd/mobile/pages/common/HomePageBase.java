package com.solvd.mobile.pages.common;

import com.solvd.mobile.pages.components.Browse;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened(int timeout);

    public abstract void clickAllowNotificationsIfPresent(int timeout);

    public abstract HomePageBase closeFeedbackModal();

    public abstract SideMenuPageBase clickOpenSideMenu();

    public abstract Browse clickBrowse();
}
