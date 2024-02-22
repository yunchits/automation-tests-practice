package com.solvd.mobile.modals;

import com.solvd.mobile.modals.common.LogOutConfirmationModalBase;
import com.solvd.mobile.pages.AuthPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogOutConfirmationModalBase.class)
public class LogOutConfirmationModal extends LogOutConfirmationModalBase {

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private ExtendedWebElement confirmButton;

    public LogOutConfirmationModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LogOutConfirmationModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public AuthPage clickConfirmLogOut() {
        confirmButton.click();
        return new AuthPage(getDriver());
    }
}
