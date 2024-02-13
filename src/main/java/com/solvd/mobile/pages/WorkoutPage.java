package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.WorkoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WorkoutPageBase.class)
public class WorkoutPage extends WorkoutPageBase {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.nike.ntc:id/className']")
    private ExtendedWebElement workoutTitle;

    public WorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getWorkoutTitleText() {
        return workoutTitle.getText();
    }

    @Override
    public boolean isPresent(int timeout) {
        return workoutTitle.isElementPresent(timeout);
    }
}
