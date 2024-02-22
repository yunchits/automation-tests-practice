package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.PassPageBase;
import com.solvd.mobile.pages.common.SignedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PassPageBase.class)
public class PassPage extends PassPageBase {

    @FindBy(xpath = "//android.widget.EditText[@resource-id='password']")
    private ExtendedWebElement passInput;

    @FindBy(xpath = "//android.widget.Button[@text='Sign In']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Your credentials are invalid']")
    private ExtendedWebElement invalidCredentialsMessage;

    public PassPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PassPageBase typePass(String pass) {
        passInput.type(pass);
        return initPage(getDriver(), PassPageBase.class);
    }

    @Override
    public SignedPageBase clickSignIn() {
        signInButton.click();
        return initPage(getDriver(), SignedPageBase.class);
    }

    @Override
    public boolean isPresent(int timeout) {
        return passInput.isElementPresent(timeout);
    }

    @Override
    public boolean isInvalidCredentialsMessagePresent(int timeout) {
        return invalidCredentialsMessage.isElementPresent(timeout);
    }
}
