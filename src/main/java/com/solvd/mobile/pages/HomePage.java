package com.solvd.mobile.pages;

import com.solvd.mobile.modals.FeedbackModal;
import com.solvd.mobile.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
@Getter
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Workouts']")
    private ExtendedWebElement homeTitle;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    private ExtendedWebElement allowButton;

    @FindBy
    private FeedbackModal feedbackModal;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitlePresent() {
        return homeTitle.isElementPresent();
    }

    @Override
    public void clickAllowNotifications() {
        allowButton.click();
    }

    @Override
    public void closeFeedbackModal() {
        feedbackModal.clickRejectButton();
    }
}
