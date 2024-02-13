package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.FilterPageBase;
import com.solvd.mobile.pages.common.ResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterPageBase.class)
public class FilterPage extends FilterPageBase {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.nike.ntc:id/intermediate']")
    private ExtendedWebElement levelIntermediateButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Done']")
    private ExtendedWebElement doneButton;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FilterPageBase clickLevelIntermediate() {
        levelIntermediateButton.click();
        return initPage(getDriver(), FilterPageBase.class);
    }

    @Override
    public ResultPageBase clickDone() {
        doneButton.click();
        return initPage(getDriver(), ResultPageBase.class);
    }
}
