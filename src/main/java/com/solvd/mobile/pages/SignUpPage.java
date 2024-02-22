package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {

    @FindBy(xpath = "//android.view.View[@text=\"Now let's make you a Nike Member. group\"]")
    private ExtendedWebElement signUpTitle;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPresent(int timeout) {
        return signUpTitle.isElementPresent(timeout);
    }
}
