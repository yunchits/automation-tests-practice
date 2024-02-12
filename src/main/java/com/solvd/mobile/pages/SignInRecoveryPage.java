package com.solvd.mobile.pages;

import com.solvd.mobile.models.TimeoutConstants;
import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.common.PassPageBase;
import com.solvd.mobile.pages.common.SignInPageBase;
import com.solvd.mobile.pages.common.SignInRecoveryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignInRecoveryPageBase.class)
public class SignInRecoveryPage extends SignInRecoveryPageBase {

    @FindBy(xpath = "//android.view.View[@text='continue_as_header group']")
    private ExtendedWebElement continueTitle;

    @FindBy(xpath = "//android.widget.Button[@text='Continue']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//android.widget.Button[@text='No, use another account']")
    private ExtendedWebElement useAnotherAccountButton;

    public SignInRecoveryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPresent(int timeout) {
        return continueTitle.isElementPresent(timeout);
    }

    @Override
    public HomePageBase clickContinue() {
        continueButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public SignInPageBase clickUseAnotherAccount() {
        useAnotherAccountButton.click();
        return initPage(getDriver(), SignInPageBase.class);
    }
}