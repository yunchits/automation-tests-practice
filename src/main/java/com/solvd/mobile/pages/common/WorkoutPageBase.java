package com.solvd.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WorkoutPageBase extends AbstractPage {

    protected WorkoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getWorkoutTitleText();

    public abstract boolean isPresent(int timeout);
}
