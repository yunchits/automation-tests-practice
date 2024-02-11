package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.PassPageBase;
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
    public HomePage clickSingIn() {
        singInButton.click();
        return new HomePage(getDriver());
    }
}
