package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.common.ReturnToAccountPageBase;
import com.solvd.mobile.pages.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ReturnToAccountPageBase.class)
public class ReturnToAccountPage extends ReturnToAccountPageBase {

    @FindBy(xpath = "//android.view.View[@text='continue_as_header group']")
    private ExtendedWebElement continueTitle;

    @FindBy(xpath = "//android.widget.Button[@text='Continue']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//android.widget.Button[@text='No, use another account']")
    private ExtendedWebElement useAnotherAccountButton;

    public ReturnToAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPresent(int timeout) {
        return continueTitle.isElementPresent(timeout);
    }

    @Override
    public SignInPageBase clickUseAnotherAccount() {
        useAnotherAccountButton.click();
        return initPage(getDriver(), SignInPageBase.class);
    }

    @Override
    public HomePageBase clickContinue() {
        continueButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}