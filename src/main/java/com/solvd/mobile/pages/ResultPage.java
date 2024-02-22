package com.solvd.mobile.pages;

import com.solvd.mobile.models.TimeoutConstants;
import com.solvd.mobile.pages.common.FilterPageBase;
import com.solvd.mobile.pages.common.ResultPageBase;
import com.solvd.mobile.pages.common.SearchPageBase;
import com.solvd.mobile.pages.components.WorkoutCard;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultPageBase.class)
public class ResultPage extends ResultPageBase {

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.nike.ntc:id/compose_view\"]/android.view.View/android.view.View/android.view.View[1]")
    private WorkoutCard workoutCard;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.nike.ntc:id/compose_view\"]/android.view.View/android.view.View/android.view.View")
    private List<WorkoutCard> workoutCards;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Filter']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement backButton;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WorkoutCard getFistWorkoutCard() {
        return workoutCard;
    }

    @Override
    public List<WorkoutCard> getVisableWorkoutCards() {
        workoutCard.isUIObjectPresent(TimeoutConstants.SHORT_TIMEOUT_SECONDS);
        return workoutCards;
    }

    @Override
    public FilterPageBase clickFilterButton() {
        filterButton.click();
        return initPage(getDriver(), FilterPageBase.class);
    }

    @Override
    public SearchPageBase clickBack() {
        backButton.click();
        return initPage(getDriver(), SearchPageBase.class);
    }
}
