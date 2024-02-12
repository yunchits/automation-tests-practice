package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.SavedPageBase;
import com.solvd.mobile.pages.common.SearchPageBase;
import com.solvd.mobile.pages.components.WorkoutCard;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SavedPageBase.class)
public class SavedPage extends SavedPageBase {

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View")
    private WorkoutCard card;

    public SavedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WorkoutCard getCard() {
        return card;
    }
}
