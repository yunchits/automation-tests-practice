package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.common.SignedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignedPageBase.class)
public class SignedPage extends SignedPageBase {

    @FindBy(xpath = "//android.view.View[@text='You have been signed in successfully. group']")
    private ExtendedWebElement signedMassage;

    @FindBy(xpath = "//android.widget.Button[@text='Continue']")
    private ExtendedWebElement continueButton;

    public SignedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPresent() {
        return signedMassage.isElementPresent();
    }

    @Override
    public HomePageBase clickContinue() {
        continueButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
