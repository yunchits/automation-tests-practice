package com.solvd.mobile.pages;

import com.solvd.mobile.modals.FeedbackModal;
import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.common.SideMenuPageBase;
import com.solvd.mobile.pages.components.Browse;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Workouts']")
    private ExtendedWebElement homeTitle;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    private ExtendedWebElement allowButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open']")
    private ExtendedWebElement openSideMenuButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Browse']")
    private ExtendedWebElement browse;

    @FindBy
    private FeedbackModal feedbackModal;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPresent(int timeout) {
        return homeTitle.isElementPresent(timeout) || allowButton.isElementPresent(timeout);
    }

    @Override
    public void clickAllowNotifications() {
        allowButton.click();
    }

    @Override
    public void closeFeedbackModal() {
        feedbackModal.clickRejectButton();
    }

    @Override
    public SideMenuPageBase clickOpenSideMenu() {
        openSideMenuButton.click();
        return initPage(getDriver(), SideMenuPageBase.class);
    }

    @Override
    public Browse clickBrowse() {
        browse.click();
        return new Browse(getDriver());
    }
}
