package com.solvd.mobile.pages.components;

import com.solvd.mobile.pages.common.WorkoutPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WorkoutCard extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//android.widget.TextView[@text][1]")
    private ExtendedWebElement workoutTitle;

    @FindBy(xpath = ".//android.widget.TextView[@text][2]")
    private ExtendedWebElement description;

    @FindBy(xpath = ".//android.widget.CheckBox")
    private ExtendedWebElement saveCheckBox;

    public WorkoutCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getWorkoutTitle() {
        return workoutTitle.getText();
    }

    public String getDescriptionTitle() {
        return description.getText();
    }

    public void clickSave() {
        saveCheckBox.click();
    }

    public WorkoutPageBase openWorkout() {
        workoutTitle.click();
        return initPage(getDriver(), WorkoutPageBase.class);
    }
}