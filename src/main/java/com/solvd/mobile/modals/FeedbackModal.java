package com.solvd.mobile.modals;

import com.solvd.mobile.modals.common.FeedbackModalBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FeedbackModalBase.class)
public class FeedbackModal extends FeedbackModalBase {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.nike.ntc:id/tv_no_button']")
    private ExtendedWebElement rejectButton;

    public FeedbackModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public FeedbackModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickRejectButton() {
        rejectButton.click();
    }
}
