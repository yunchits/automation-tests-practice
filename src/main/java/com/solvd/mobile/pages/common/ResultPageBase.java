package com.solvd.mobile.pages.common;

import com.solvd.mobile.pages.components.WorkoutCard;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ResultPageBase extends AbstractPage implements IMobileUtils {

    protected ResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<WorkoutCard> getAllTrainingCards();

    public abstract FilterPageBase clickFilterButton();

    public abstract SearchPageBase clickBack();
}
