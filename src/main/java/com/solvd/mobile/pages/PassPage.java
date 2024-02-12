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
    private ExtendedWebElement singInButton;

    public PassPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typePass(String pass) {
        passInput.type(pass);
    }

    @Override
    public SignedPageBase clickSignIn() {
        singInButton.click();
        return initPage(getDriver(), SignedPageBase.class);
    }

    @Override
    public boolean isPresent(int timeout) {
        return passInput.isElementPresent(timeout);
    }
}
