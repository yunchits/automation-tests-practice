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

    @FindBy(xpath = "//android.widget.TextView[@text='subheader-text']")
    private ExtendedWebElement emailTitle;

    @FindBy(xpath = "//android.widget.Button[@text='Continue']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//android.widget.Button[@text='No, use another account']")
    private ExtendedWebElement rejectButton;

    public ReturnToAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPageBase clickRejectButton() {
        rejectButton.click();
        return initPage(getDriver(), SignInPageBase.class);
    }

    @Override
    public HomePageBase clickContinueButton() {
        continueButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public String getEmailTitleText() {
        return emailTitle.getText();
    }
}
