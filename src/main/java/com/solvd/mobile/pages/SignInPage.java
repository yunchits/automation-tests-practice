package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.PassPageBase;
import com.solvd.mobile.pages.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(xpath = "//android.widget.TextView[text()]")
    private ExtendedWebElement countryText; //todo

    @FindBy(xpath = "//android.widget.EditText[@resource-id='username']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//android.widget.Button[@text='continue']")
    private ExtendedWebElement continueButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPresent() {
        return emailInput.isElementPresent();
    }

    @Override
    public String getCountyText() { //todo
        return countryText.getText();
    }

    @Override
    public void typeEmail(String email) {
        emailInput.type(email);
    }

    @Override
    public PassPageBase clickContinue() {
        continueButton.click();
        return initPage(getDriver(), PassPageBase.class);
    }


}
