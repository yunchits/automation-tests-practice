package com.solvd.mobile.pages.common;

import com.solvd.mobile.pages.components.WorkoutCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SavedPageBase extends AbstractPage {

    protected SavedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WorkoutCard getCard();
}
