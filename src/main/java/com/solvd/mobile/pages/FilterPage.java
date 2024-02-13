package com.solvd.mobile.pages;

import com.solvd.mobile.models.Filters;
import com.solvd.mobile.pages.common.FilterPageBase;
import com.solvd.mobile.pages.common.ResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterPageBase.class)
public class FilterPage extends FilterPageBase {

    @FindBy(id = "com.nike.ntc:id/%s")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Done']")
    private ExtendedWebElement doneButton;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FilterPageBase selectFilter(Filters filter) {
        filterButton.format(filter.getId()).click();
        return initPage(getDriver(), FilterPageBase.class);
    }

    @Override
    public ResultPageBase clickDone() {
        doneButton.click();
        return initPage(getDriver(), ResultPageBase.class);
    }
}
