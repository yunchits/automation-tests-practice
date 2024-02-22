package com.solvd.mobile.pages;

import com.solvd.mobile.pages.common.HomePageBase;
import com.solvd.mobile.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    @FindBy(id = "com.nike.ntc:id/search_src_text")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.nike.ntc:id/title']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement backButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ResultPage searchByText(String text) {
        searchInput.type(text);
        searchButton.click();
        return new ResultPage(getDriver());
    }

    @Override
    public HomePageBase clickBack() {
        backButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
