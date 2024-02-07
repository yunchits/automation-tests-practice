package com.solvd.web.ebay.pages;

import com.solvd.web.ebay.pages.components.HomeHeader;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends AbstractPage {

    @FindBy(xpath = "//header[@id='gh']")
    private HomeHeader homeHeader;

    @FindBy(xpath = "//div[@id='gh-top']//a[text()='Sign in']")
    private ExtendedWebElement singIn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public LoginPage clickSingIn() {
        singIn.click();
        return new LoginPage(getDriver());
    }
}
