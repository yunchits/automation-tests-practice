package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.SavedPageBase;
import com.solvd.mobile.pages.common.SettingsPageBase;
import com.solvd.mobile.pages.common.SideMenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SideMenuPageBase.class)
public class SideMenuPage extends SideMenuPageBase {

    @FindBy(id = "com.nike.ntc:id/nav_settings_item")
    private ExtendedWebElement settingsButton;

    @FindBy(id = "com.nike.ntc:id/nav_favorites_item")
    private ExtendedWebElement savedButton;

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SettingsPageBase clickSettings() {
        settingsButton.click();
        return initPage(getDriver(), SettingsPageBase.class);
    }

    @Override
    public SavedPageBase clickSaved() {
        savedButton.click();
        return initPage(getDriver(), SavedPageBase.class);
    }
}
