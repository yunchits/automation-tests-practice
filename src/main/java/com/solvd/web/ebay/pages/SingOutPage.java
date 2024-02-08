package com.solvd.web.ebay.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class SingOutPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='signout-banner-text']")
    private ExtendedWebElement signOutBanner;

    public SingOutPage(WebDriver driver) {
        super(driver);
    }

    public String getSingOutBannerText() {
        return signOutBanner.getText();
    }
}
