package com.solvd.mobile.pages;

import com.solvd.mobile.modals.LogOutConfirmationModal;
import com.solvd.mobile.pages.common.SettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    @FindBy(xpath = "//android.widget.Button[@text='Log Out']")
    private ExtendedWebElement logOutButton;

    @FindBy
    private LogOutConfirmationModal logOutConfirmationModal;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LogOutConfirmationModal clickLogOut() {
        swipe(logOutButton);
        logOutButton.click();
        return logOutConfirmationModal;
    }
}
