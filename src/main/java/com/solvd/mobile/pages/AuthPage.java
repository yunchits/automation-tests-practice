package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.AuthPageBase;
import com.solvd.mobile.pages.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AuthPageBase.class)
public class AuthPage extends AuthPageBase {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.nike.ntc:id/overviewTitle']")
    private ExtendedWebElement authTitle;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.nike.ntc:id/action_log_in']")
    private ExtendedWebElement signInButton;

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPageBase clickSignInButton() {
        signInButton.click();
        return initPage(getDriver(), SignInPageBase.class);
    }

    @Override
    public boolean isAuthTitlePresent(int timeout) {
        return authTitle.isElementPresent(timeout);
    }
}
